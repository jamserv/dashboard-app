package co.com.accionese.dashboard.controllers;

import co.com.accionese.dashboard.api.Constants;
import co.com.accionese.dashboard.dto.KeyValueObject;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.services.Brands;
import co.com.accionese.dashboard.services.InvestmentAnualByBrand;
import co.com.accionese.dashboard.services.InvestmentByMonths;
import co.com.accionese.dashboard.services.InvestmentBranBySupportType;
import co.com.accionese.dashboard.services.InvestmentBySector;
import co.com.accionese.dashboard.services.InvestmentByCity;
import co.com.accionese.dashboard.services.InvestmentBySupportType;
import co.com.accionese.dashboard.services.InvestmentByTopCampaign;
import co.com.accionese.dashboard.services.TotalInversment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    InvestmentByMonths inversionMonths;

    @Autowired
    InvestmentBySupportType invertionBySupportType;

    @Autowired
    InvestmentBranBySupportType invertionBranBySupportType;

    @Autowired
    InvestmentByCity investmentByCity;

    @Autowired
    InvestmentBySector investmentBySector;

    @Autowired
    InvestmentByTopCampaign investmentByTopCampaign;

    @Autowired
    InvestmentAnualByBrand brandAnnualInvestment;

    @Autowired
    Brands brands;
    
    @Autowired
    TotalInversment totalInversment;
    
      /**
     * see GET_ALL_BRANDS
     *
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getTotalInversment")
    @ResponseBody
    BaseResponse getTotalInversment(@RequestParam("years") String years) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, "--");
        
        return totalInversment.genericQuery(params);
    }

    /**
     * see GET_ALL_BRANDS
     *
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getAllBrands")
    @ResponseBody
    List<KeyValueObject> getAllBrands() {
        Map<String, String> params = new LinkedHashMap<>();
        return brands.get(params);
    }

    /**
     * see INV_ANUAL_TYPE
     *
     * @param years
     * @param brands
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvMonths")
    @ResponseBody
    BaseResponse getEvolutiveInvMonths(@RequestParam("years") String years, @RequestParam("brands") String brands) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, brands);

        return inversionMonths.genericQuery(params);
    }

    /**
     * see INV_SUPPORT_TYPE
     *
     * @param years
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getInvBySupportType")
    @ResponseBody
    BaseResponse getInvBySupportType(@RequestParam("years") String years) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, "--");

        return invertionBySupportType.genericQuery(params);
    }

    /**
     * see EVO_INV_BRAND_SUPPORT_TYPE
     *
     * @param years
     * @param brands
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvertionBranBySupportTypeService")
    @ResponseBody
    BaseResponse getEvolutiveInvestmentBranBySupportTypeService(@RequestParam("years") String years, @RequestParam("brands") String brands) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, brands);

        return invertionBranBySupportType.genericQuery(params);
    }

    /**
     * see INV_BY_CITY
     *
     * @param years
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getInvestmentByCity")
    @ResponseBody
    BaseResponse getInvestmentByCity(@RequestParam("years") String years) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, "--");

        return investmentByCity.genericQuery(params);
    }

    /**
     * see INV_BY_SECTOR
     *
     * @param years
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveInvestmentSector")
    @ResponseBody
    BaseResponse getEvolutiveInvestmentSetor(@RequestParam("years") String years) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, "--");

        return investmentBySector.genericQuery(params);
    }

    /**
     * see TOP_CAMPANAS
     *
     * @param years
     * @param brands
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getInvestmentByTopCampaign")
    @ResponseBody
    BaseResponse getInvestmentByTopCampaign(@RequestParam("years") String years, @RequestParam("brands") String brands) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, brands);

        return investmentByTopCampaign.genericQuery(params);
    }

    /**
     * see EV_INV_BRAND
     *
     * @param years
     * @param brands
     * @return
     */
    @GetMapping(Constants.DASHBOARD_URI + "/getEvolutiveBrandAnnualInvestment")
    @ResponseBody
    BaseResponse getEvolutiveBrandAnnualInvestment(@RequestParam("years") String years, @RequestParam("brands") String brands) {
        Map<String, String> params = new LinkedHashMap<>();
        buildParams(params, years, brands);

        return brandAnnualInvestment.genericQuery(params);
    }

    private void buildParams(Map<String, String> params, String years, String brands) {
        StringBuilder builder = new StringBuilder();

        if (!years.isEmpty()) {
            if (!years.equalsIgnoreCase("--")) {
                builder.append(" AND year:" + years);
            }
        }
        if (!brands.isEmpty()) {
            if (!brands.equalsIgnoreCase("--")) {
                builder.append(" AND brand:(" + brands);
                builder.append(")");
            }
        }

        params.put("where", builder.toString());
    }

}
