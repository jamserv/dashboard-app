package co.com.accionese.dashboard.api;

import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import java.util.Map;

/**
 *
 * @author janez
 */
public interface IBaseRequest {

    public BaseResponse genericQuery(Map<String, String> params);

    public void buildQuery(Map<String, String> params) throws Exception;

    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception;

}
