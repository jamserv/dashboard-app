package co.com.accionese.dashboard.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author janez
 */
@Service
public class PentahoService {

    private RestTemplate restTemplate;
    private String pentahoHost;

    @Autowired
    public PentahoService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String genericPentahoRequest(MultiValueMap<String, String> params) throws Exception {
        String url = "http://bi.accionese.com/pentaho/plugin/cda/api/doQuery?";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", getAuth());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        ResponseEntity<String> exchange = restTemplate.postForEntity(url, request, String.class);
        String response = exchange.getBody().toString();

        return response;
    }

    protected String getAuth() {
        String str = "invitado:Invitado123";
        org.apache.tomcat.util.codec.binary.Base64 b = new org.apache.tomcat.util.codec.binary.Base64();
        String encoding = new String(b.encode(str.getBytes()));
        String authHeader = "Basic " + new String(encoding);
        return authHeader;
    }        

    @Value("${solr.host}")
    public void setPentahoHost(String pentahoHost) {
        this.pentahoHost = pentahoHost;
    }
    
    
}
