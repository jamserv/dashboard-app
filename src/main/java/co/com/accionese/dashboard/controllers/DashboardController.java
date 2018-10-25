package co.com.accionese.dashboard.controllers;

import co.com.accionese.dashboard.api.Constants;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.services.EvolutiveInvestmentInMonthsService;
import co.com.accionese.dashboard.services.EvolutiveInvestmentBranBySupportTypeService;
import co.com.accionese.dashboard.services.EvolutiveInvestmentSetor;
import co.com.accionese.dashboard.services.InvestmentByCity;
import co.com.accionese.dashboard.services.InvestmentBySupportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    EvolutiveInvestmentInMonthsService evolutiveInversionMonths;

    @Autowired
    InvestmentBySupportTypeService invertionBySupportTypeService;

    @Autowired
    EvolutiveInvestmentBranBySupportTypeService evolutiveInvertionBranBySupportTypeService;

    @Autowired
    InvestmentByCity investmentByCity;
    
    @Autowired
    EvolutiveInvestmentSetor evolutiveInvestmentSetor;

    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvMonths")
    @ResponseBody
    BaseResponse getEvolutiveInvMonths() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return evolutiveInversionMonths.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getInvBySupportType")
    @ResponseBody
    BaseResponse getInvBySupportType() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return invertionBySupportTypeService.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvertionBranBySupportTypeService")
    @ResponseBody
    BaseResponse getEvolutiveInvestmentBranBySupportTypeService() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return evolutiveInvertionBranBySupportTypeService.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getInvestmentByCity")
    @ResponseBody
    BaseResponse getInvestmentByCity() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return investmentByCity.genericQuery(params);
    }

    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvestmentSetor")
    @ResponseBody
    BaseResponse getEvolutiveInvestmentSetor() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return evolutiveInvestmentSetor.genericQuery(params);
    }

}
