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
 * @see BrandMonthInvestmentQuery
 * @author janez
 */
@Service
public class InvestmentAnualByBrand extends BaseQueryBuilder implements IBaseRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        return super.genericQuery(this, params);
    }

    @Override
    public void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "EV_INV_BRAND");
    }

    @Override
    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {
        List<String> categories = new ArrayList<>();

        Map<String, List<Long>> seriesMap = new LinkedHashMap<>();
        Map<String, String> seriesMapFix = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            String cat = content.getMonth().substring(0, 3) + " " + content.getYear();
            buildCategories(categories, cat);

            String key = content.getBrand().replaceAll(" ", "");

            if (seriesMap.containsKey(key)) {
                List<Long> l = seriesMap.get(key);
                long value = Long.parseLong(content.getCost());
                l.add(value);
                seriesMap.put(key, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(Long.parseLong(content.getCost()));
                seriesMap.put(key, v);
            }
            seriesMapFix.put(key.replaceAll(" ", "") + " " + cat, key);
        }

        fixNullableIndex(categories, seriesMapFix, seriesMap);

        List<Serie> series = buildSeriesWithMap(seriesMap);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);
    }

    private void buildCategories(List<String> categories, String city) {
        if (!categories.contains(city)) {
            categories.add(city);
        }
    }

    private void fixNullableIndex(List<String> categories, Map<String, String> seriesMapFix, Map<String, List<Long>> seriesMap) {
        int counter = 0;
        for (String category : categories) {
            for (Map.Entry<String, List<Long>> entry : seriesMap.entrySet()) {
                String key = entry.getKey();
                List<Long> value = entry.getValue();
                String brand = key.replaceAll(" ", "");

                if (!seriesMapFix.containsKey(brand + " " + category)) {
                    value.add(counter, 0L);
                    seriesMap.put(key, value);
                }
            }
            counter++;
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
