package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.BaseQueryBuilder;
import co.com.accionese.dashboard.api.GenericRequest;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import co.com.accionese.dashboard.dto.EvolutiveInvestmentDto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.accionese.dashboard.api.IBaseRequest;

/**
 * @see SectorInvestmentQuery
 * @author janez
 */
@Service
public class InvestmentBySector extends BaseQueryBuilder implements IBaseRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        return super.genericQuery(this, params);
    }

    @Override
    public void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "INV_BY_SECTOR");
        params.put("fl", "sector,year,month,cost");
    }

    @Override
    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {
        List<String> categories = new ArrayList<>();
        Map<String, List<Long>> seriesMap = new LinkedHashMap<>();
        Map<String, String> allMap = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            existValue(allMap, content);
            buildCategories(categories, content.getMonth().substring(0, 3) + " " + content.getYear());

//            String key = content.getSector();
//            Long cost = Long.parseLong(content.getCost());
//
//            if (seriesMap.containsKey(key)) {
//                List<Long> l = seriesMap.get(key);
//                l.add(cost);
//                seriesMap.put(key, l);
//            } else {
//                List<Long> v = new ArrayList<>();
//                v.add(cost);
//                seriesMap.put(key, v);
//            }
        }

        for (Map.Entry<String, String> entry : allMap.entrySet()) {
            String key = entry.getKey();
            Long value = Long.parseLong(entry.getValue());

            String brand = key.split("-")[0];

            if (seriesMap.containsKey(brand)) {
                List<Long> l = seriesMap.get(brand);
                l.add(value);
                seriesMap.put(brand, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(value);
                seriesMap.put(brand, v);
            }

        }

        List<Serie> series = buildSeriesWithMap(seriesMap);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);
    }

    private void existValue(Map<String, String> allMap, EvolutiveInvestmentDto content) {
        String key = content.getSector() + "-" + content.getMonth() + content.getYear();
        if (allMap.containsKey(key)) {
            Long val = Long.parseLong(allMap.get(key)) + Long.parseLong(content.getCost());
            allMap.put(key, String.valueOf(val));
        } else {
            allMap.put(key, content.getCost());
        }
    }

    private void buildCategories(List<String> categories, String city) {
        if (!categories.contains(city)) {
            categories.add(city);
        }
    }

    private List<Serie> buildSeriesWithMap(Map<String, List<Long>> seriesMap) {
        List<Serie> series = new ArrayList<>();

        for (Map.Entry<String, List<Long>> entry : seriesMap.entrySet()) {
            String key = entry.getKey();
            List<Long> value = entry.getValue();

            series.add(new Serie(key, value));
        }

        return series;
    }

}
