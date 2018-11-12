package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.dto.KeyValueObject;
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
public class Brands {

    private RestTemplate restTemplate;
    private String solrHost;

    @Autowired
    public Brands(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<KeyValueObject> get(Map<String, String> params) {
        try {
            params.put("operationType", "GET_ALL_BRANDS");
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

        String query = operationType + "&rows=200&start=0";

        builder = builder.path("/solr/dashboard-core/select?q=operationType:" + query);

        return builder.build();
    }

    private List<KeyValueObject> getData(UriComponents uriComponents) {
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

    private List<KeyValueObject> buildResponse(String content) throws ParseException {
        List<KeyValueObject> list = new ArrayList<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(content);
        JSONObject tagResponse = (JSONObject) object.get("response");
        JSONArray docs = (JSONArray) tagResponse.get("docs");
        for (Object doc : docs) {
            JSONObject objectMapper = (JSONObject) doc;

            KeyValueObject keyValueObject = new KeyValueObject();
            keyValueObject.setKey(objectMapper.get("brand").toString());

            list.add(keyValueObject);
        }

        return list;
    }

    @Value("${solr.host}")
    public void setPentahoHost(String solrHost) {
        this.solrHost = solrHost;
    }

}
