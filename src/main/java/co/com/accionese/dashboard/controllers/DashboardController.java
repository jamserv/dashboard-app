package co.com.accionese.dashboard.controllers;

import co.com.accionese.dashboard.api.Constants;
import co.com.accionese.dashboard.dto.DashboardDto;
import co.com.accionese.dashboard.services.DashboardService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author janez
 */
@RestController(value = Constants.DASHBOARD_URI)
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/dashboard")
    @ResponseBody
    List<DashboardDto> getDashboard() {
        Map<String, Object> params = null;
        return dashboardService.getDashboard(params);
    }

}
