package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.dto.DashboardDto;
import java.net.URLEncoder;
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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author janez
 */
@Service
public class DashboardService implements Dashboard {

    private RestTemplate restTemplate;
    private String solrHost;

    @Autowired
    public DashboardService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public List<DashboardDto> getDashboard(Map<String, Object> params) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(solrHost);
            builder = builder.path("/solr/dashboard-core/select?q=Ciudad:BARRANQUILLA&rows=80000&start=1");
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

    private List<DashboardDto> buildResponse(String content) throws ParseException {
        List<DashboardDto> list = new ArrayList<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(content);
        JSONObject tagResponse = (JSONObject) object.get("response");
        JSONArray docs = (JSONArray) tagResponse.get("docs");
        for (Object doc : docs) {
            JSONObject objectMapper = (JSONObject) doc;

            DashboardDto dashboardDto = new DashboardDto();
            dashboardDto.setAdvertiser(fieldValidator(objectMapper, "Anunciante"));
            dashboardDto.setCreativity(fieldValidator(objectMapper, "Creatividad"));
            dashboardDto.setSector(fieldValidator(objectMapper, "Sector"));
            dashboardDto.setProduct(fieldValidator(objectMapper, "Producto"));
            dashboardDto.setBell(fieldValidator(objectMapper, "Campana"));
            dashboardDto.setProvider(fieldValidator(objectMapper, "Proveedor"));
            dashboardDto.setCostInThousand(Double.parseDouble(fieldValidator(objectMapper, "CostoEnMiles")));
            dashboardDto.setCentral(fieldValidator(objectMapper, "Central"));
            dashboardDto.setCity(fieldValidator(objectMapper, "Ciudad"));
            dashboardDto.setType(fieldValidator(objectMapper, "Tipo"));
            dashboardDto.setBrand(fieldValidator(objectMapper, "Marca"));
            dashboardDto.setGroup(fieldValidator(objectMapper, "Grupo"));
            dashboardDto.setInitialDt(fieldValidator(objectMapper, "FechaInicial"));
            dashboardDto.setSense(fieldValidator(objectMapper, "Sentido"));

            list.add(dashboardDto);
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
    public void setMasterHost(String solrHost) {
        this.solrHost = solrHost;
    }

}
