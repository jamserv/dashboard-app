package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.dto.DashboardDto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janez
 */
public interface Dashboard {

    public List<DashboardDto> getDashboard(Map<String, Object> params);
}
