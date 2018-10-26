package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author janez
 */
public interface BaseRequest {  

    public BaseResponse genericQuery(MultiValueMap<String, String> params);
}
