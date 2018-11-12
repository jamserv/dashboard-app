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
import org.springframework.stereotype.Service;
import co.com.accionese.dashboard.api.IBaseRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @see CampaignInvestmentQuery
 * @author janez
 */
@Service
public class InvestmentByTopCampaign extends BaseQueryBuilder implements IBaseRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        return super.genericQuery(this, params);
    }

    @Override
    public void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "TOP_CAMPANAS");
        params.put("fl", "brand,year,month,cost");
    }

    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {

        List<String> categories = new ArrayList<>();

        Map<String, Long> serieExistMap = new LinkedHashMap<>();
        Map<String, List<Long>> values = new LinkedHashMap<>();
        Map<String, String> allMap = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            existValue(allMap, content);

            String cat = content.getMonth().substring(0, 3) + " " + content.getYear();
            buildCategories(categories, cat);

            String key = content.getBrand();
            Long cost = Long.parseLong(content.getCost());

            /*
            if (values.containsKey(key)) {
                List<Long> l = values.get(key);

                l.add(cost);
                values.put(key, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(cost);
                values.put(key, v);
            }
            */
            serieExistMap.put(key.replaceAll(" ", "") + " " + cat, cost);
        }

        for (Map.Entry<String, String> entry : allMap.entrySet()) {
            String key = entry.getKey();
            Long value = Long.parseLong(entry.getValue());

            String brand = key.split("-")[0];

            if (values.containsKey(brand)) {
                List<Long> l = values.get(brand);
                l.add(value);
                values.put(brand, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(value);
                values.put(brand, v);
            }

        }

        fixNullableIndex(categories, serieExistMap, values);

        List<Serie> series = buildSeriesWithMap(values);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);

    }

    private void existValue(Map<String, String> allMap, EvolutiveInvestmentDto content) {
        String key = content.getBrand() + "-" + content.getMonth() + content.getYear();
        if (allMap.containsKey(key)) {
            Long val = Long.parseLong(allMap.get(key)) + Long.parseLong(content.getCost());
            allMap.put(key, String.valueOf(val));
        } else {
            allMap.put(key, content.getCost());
        }
    }

    private void fixNullableIndex(List<String> categories, Map<String, Long> serieExistMap, Map<String, List<Long>> seriesMap) {
        int counter = 0;
        for (String category : categories) {
            for (Map.Entry<String, List<Long>> entry : seriesMap.entrySet()) {
                String key = entry.getKey();
                List<Long> value = entry.getValue();
                String brand = key.replaceAll(" ", "");

                if (!serieExistMap.containsKey(brand + " " + category)) {
                    value.add(counter, 0L);
                    seriesMap.put(key, value);
                }
            }
            counter++;
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
