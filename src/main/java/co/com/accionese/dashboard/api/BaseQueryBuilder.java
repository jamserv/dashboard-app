package co.com.accionese.dashboard.api;

import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import java.util.Map;
import org.springframework.http.HttpStatus;

/**
 *
 * @author janez
 */
public class BaseQueryBuilder {

    public BaseResponse genericQuery(IBaseRequest baseRequest, Map<String, String> params) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseRequest.buildQuery(params);
            baseRequest.buildResponse(baseResponse, params);
            baseResponse.setHttpStatus(HttpStatus.OK);
            return baseResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return baseResponse;
        }
    }

}
