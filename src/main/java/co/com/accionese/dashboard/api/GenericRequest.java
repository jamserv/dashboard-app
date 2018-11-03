package co.com.accionese.dashboard.api;

import co.com.accionese.dashboard.dto.EvolutiveInvestmentDto;
import java.util.ArrayList;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author janez
 */
@Component
public class GenericRequest {

    private RestTemplate restTemplate;
    private String solrHost;

    @Autowired
    public GenericRequest(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<EvolutiveInvestmentDto> get(Map<String, String> params) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(solrHost);
            UriComponents uriComponent = buildRequestParams(params, builder);

            return getData(uriComponent);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private UriComponents buildRequestParams(Map<String, String> params, UriComponentsBuilder builder) throws Exception {
        String operationType = params.get("operationType");
        String where = buildWhere(params);

        String query = operationType + where + "&rows=2000&start=0";

        builder = builder.path("/solr/dashboard-core/select?q=operationType:" + query);

        return builder.build();
    }

    private List<EvolutiveInvestmentDto> getData(UriComponents uriComponents) {
        try {
            String url = uriComponents.toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>("", headers);
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            String response = exchange.getBody();

            return buildResponse(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private String buildWhere(Map<String, String> params) {        
        if (params.get("where").length() > 0) {
            return params.get("where");            
        }
        return "";
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
            investmentSectorDto.setBrand(fieldValidator(objectMapper, "brand"));
            investmentSectorDto.setCost(fieldValidator(objectMapper, "cost"));
            investmentSectorDto.setMonth(fieldValidator(objectMapper, "month"));
            investmentSectorDto.setYear(fieldValidator(objectMapper, "year"));
            investmentSectorDto.setType(fieldValidator(objectMapper, "type"));
            investmentSectorDto.setCity(fieldValidator(objectMapper, "city"));
            investmentSectorDto.setSector(fieldValidator(objectMapper, "sector"));

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
