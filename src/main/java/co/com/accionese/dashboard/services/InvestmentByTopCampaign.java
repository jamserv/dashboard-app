package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import co.com.accionese.dashboard.dto.EvolutiveInvestmentDto;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import co.com.accionese.dashboard.api.IBaseRequest;

/**
 *
 * @author janez
 */
@Service
public class InvestmentByTopCampaign implements IBaseRequest {

    private RestTemplate restTemplate;
    private String solrHost;

    @Autowired
    public InvestmentByTopCampaign(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            buildQuery(params);
            buildBaseResponse(baseResponse, params);
            baseResponse.setHttpStatus(HttpStatus.OK);
            return baseResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return baseResponse;
        }
    }

    private void buildQuery(Map<String, String> params) throws Exception {
        params.put("paramTypeParameter", "%");
        params.put("paramBrandParameterArray", "%");
        params.put("paramBrandParameter", "%");
        params.put("paramCityParameter", "%");

        params.put("path", "/public/Sipex2/Dashboard/Dashboard.cda");
        params.put("dataAccessId", "CampaignInvestmentQuery");

        params.put("outputIndexId", "1");
        params.put("pageSize", "0");
        params.put("pageStart", "0");
        params.put("sortBy", "");
        params.put("paramsearchBox", "");
    }

    private void buildBaseResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {        

        List<String> categories = new ArrayList<>();

        Map<String, Long> serieExistMap = new LinkedHashMap<>();

        Map<String, List<Long>> values = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = getDashboard(null);
        for (EvolutiveInvestmentDto content : list) {
            String cat = content.getMonth().substring(0, 3) + " " + content.getYear();
            buildCategories(categories, cat);
            
            String key = content.getBrand();
            Long cost = Long.parseLong(content.getCost());
            
            if (values.containsKey(key)) {
                List<Long> l = values.get(key);
                
                l.add(cost);
                values.put(key, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(cost);
                values.put(key, v);
            }
            serieExistMap.put(key.replaceAll(" ", "") + " " + cat, cost);
        }

        fixNullableIndex(categories, serieExistMap, values);

        List<Serie> series = buildSeriesWithMap(values);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);

    }

    private void fixNullableIndex(List<String> categories, Map<String, Long> serieExistMap, Map<String, List<Long>> seriesMap) {
        int counter = 0;
        for (String category : categories) {
            for (Map.Entry<String, List<Long>> entry : seriesMap.entrySet()) {
                String key = entry.getKey();
                List<Long> value = entry.getValue();
                String brand = key.replaceAll(" ", "");

                if (!serieExistMap.containsKey(brand + " " + category)) {
                    value.add(counter, 0L);
                    seriesMap.put(key, value);
                }
            }
            counter++;
        }
    }

    private void buildCategories(List<String> categories, String city) {
        if (!categories.contains(city)) {
            categories.add(city);
        }
    }

    private List<Serie> buildSeriesWithMap(Map<String, List<Long>> seriesMap) {
        List<Serie> series = new ArrayList<>();

        for (Map.Entry<String, List<Long>> entry : seriesMap.entrySet()) {
            String key = entry.getKey();
            List<Long> value = entry.getValue();

            series.add(new Serie(key, value));
        }

        return series;
    }

    public List<EvolutiveInvestmentDto> getDashboard(Map<String, Object> params) {
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(solrHost);
            String query = "operationType:TOP_CAMPANAS&rows=5000&start=0";
            builder = builder.path("/solr/dashboard-core/select?q=" + query);
            if (params != null) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    builder.queryParam(entry.getKey(), URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                }
            }
            UriComponents uriComponents = builder.build();
            String url = uriComponents.toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>("", headers);
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            String response = exchange.getBody().toString();

            return buildResponse(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<EvolutiveInvestmentDto> buildResponse(String content) throws ParseException {
        List<EvolutiveInvestmentDto> list = new ArrayList<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(content);
        JSONObject tagResponse = (JSONObject) object.get("response");
        JSONArray docs = (JSONArray) tagResponse.get("docs");
        for (Object doc : docs) {
            JSONObject objectMapper = (JSONObject) doc;

            EvolutiveInvestmentDto investmentSectorDto = new EvolutiveInvestmentDto();

            investmentSectorDto.setYear(fieldValidator(objectMapper, "year"));
            investmentSectorDto.setMonth(fieldValidator(objectMapper, "month"));
            investmentSectorDto.setBrand(fieldValidator(objectMapper, "brand"));
            investmentSectorDto.setCost(fieldValidator(objectMapper, "cost"));

            list.add(investmentSectorDto);
        }

        return list;
    }

    private String fieldValidator(JSONObject objectMapper, String field) {
        if (objectMapper.get(field) == null) {
            return "--";
        }
        return objectMapper.get(field).toString();
    }

    @Value("${solr.host}")
    public void setPentahoHost(String solrHost) {
        this.solrHost = solrHost;
    }

}
