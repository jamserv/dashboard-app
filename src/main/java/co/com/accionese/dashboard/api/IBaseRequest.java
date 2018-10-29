package co.com.accionese.dashboard.api;

import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import java.util.Map;

/**
 *
 * @author janez
 */
public interface IBaseRequest {  

    public BaseResponse genericQuery(Map<String, String> params);
}
