package co.com.accionese.dashboard.controllers;

import co.com.accionese.dashboard.api.Constants;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.services.InvestmentAnualByBrand;
import co.com.accionese.dashboard.services.InvestmentByMonths;
import co.com.accionese.dashboard.services.InvestmentBranBySupportType;
import co.com.accionese.dashboard.services.InvestmentBySector;
import co.com.accionese.dashboard.services.InvestmentByCity;
import co.com.accionese.dashboard.services.InvestmentBySupportType;
import co.com.accionese.dashboard.services.InvestmentByTopCampaign;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author janez
 */
@RestController
@CrossOrigin
public class DashboardController {

    @Autowired
    InvestmentByMonths evolutiveInversionMonths;

    @Autowired
    InvestmentBySupportType invertionBySupportTypeService;

    @Autowired
    InvestmentBranBySupportType evolutiveInvertionBranBySupportTypeService;

    @Autowired
    InvestmentByCity investmentByCity;

    @Autowired
    InvestmentBySector evolutiveInvestmentSector;

    @Autowired
    InvestmentByTopCampaign investmentByTopCampaign;
    
    @Autowired
    InvestmentAnualByBrand evolutiveBrandAnnualInvestmentService;

    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvMonths")
    @ResponseBody
    BaseResponse getEvolutiveInvMonths() {
        Map<String, String> params = new LinkedHashMap<>();
        return evolutiveInversionMonths.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getInvBySupportType")
    @ResponseBody
    BaseResponse getInvBySupportType() {
        Map<String, String> params = new LinkedHashMap<>();
        return invertionBySupportTypeService.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvertionBranBySupportTypeService")
    @ResponseBody
    BaseResponse getEvolutiveInvestmentBranBySupportTypeService() {
        Map<String, String> params = new LinkedHashMap<>();
        return evolutiveInvertionBranBySupportTypeService.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getInvestmentByCity")
    @ResponseBody
    BaseResponse getInvestmentByCity() {
        Map<String, String> params = new LinkedHashMap<>();
        return investmentByCity.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvestmentSector")
    @ResponseBody
    BaseResponse getEvolutiveInvestmentSetor() {
        Map<String, String> params = new LinkedHashMap<>();
        return evolutiveInvestmentSector.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getInvestmentByTopCampaign")
    @ResponseBody
    BaseResponse getInvestmentByTopCampaign() {
        Map<String, String> params = new LinkedHashMap<>();
        return investmentByTopCampaign.genericQuery(params);
    }
    
    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveBrandAnnualInvestment")
    @ResponseBody
    BaseResponse getEvolutiveBrandAnnualInvestment() {
        Map<String, String> params = new LinkedHashMap<>();
        return evolutiveBrandAnnualInvestmentService.genericQuery(params);
    }

}
