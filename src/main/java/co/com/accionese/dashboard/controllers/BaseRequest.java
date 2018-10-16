package co.com.accionese.dashboard.controllers;

import org.springframework.web.client.RestOperations;

/**
 *
 * @author janez
 */
public abstract class BaseRequest {
    
    protected RestOperations restOperations;    
    protected String solrHost;
    
    

    public void setRestOperations(RestOperations restOperations) {
        this.restOperations = restOperations;
    }        
    
}
