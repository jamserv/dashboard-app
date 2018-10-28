package co.com.accionese.dashboard.services.api;

import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janez
 */
public interface MultiRequest {

    public List<BaseResponse> genericQuery(Map<String, String> params);
}
