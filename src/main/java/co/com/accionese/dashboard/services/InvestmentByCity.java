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
 *
 * @author janez
 */
@Service
public class InvestmentByCity extends BaseQueryBuilder implements IBaseRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        return super.genericQuery(this, params);
    }

    @Override
    public void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "INV_BY_CITY");
        params.put("fl", "city,year,month,cost");
    }

    @Override
    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {

        List<Integer> categories = new ArrayList<>();

        Map<String, List<Long>> values = new LinkedHashMap<>();
        Map<String, String> allMap = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            existValue(allMap, content);
            buildCategories(categories, Integer.parseInt(content.getYear()));
        }

        for (Map.Entry<String, String> entry : allMap.entrySet()) {
            String key = entry.getKey();
            Long value = Long.parseLong(entry.getValue());

            String city = key.split("-")[0];

            if (values.containsKey(city)) {
                List<Long> l = values.get(city);
                l.add(value);
                values.put(city, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(value);
                values.put(city, v);
            }
        }

        List<Serie> series = buildSerieWithMap(values);
        baseResponse.setNumericCategories(categories);
        baseResponse.setSeries(series);
    }

    private void existValue(Map<String, String> allMap, EvolutiveInvestmentDto content) {
        String key = content.getCity() + "-" + content.getYear();
        if (allMap.containsKey(key)) {
            Long val = Long.parseLong(allMap.get(key)) + Long.parseLong(content.getCost());
            allMap.put(key, String.valueOf(val));
        } else {
            allMap.put(key, content.getCost());
        }
    }

    private List<Serie> buildSerieWithMap(Map<String, List<Long>> values) {
        List<Serie> series = new ArrayList<>();
        for (Map.Entry<String, List<Long>> entry : values.entrySet()) {
            String key = entry.getKey();
            List<Long> value = entry.getValue();

            series.add(new Serie(key, value));

        }
        return series;
    }

    private void buildCategories(List<Integer> categories, Integer year) {
        if (!categories.contains(year)) {
            categories.add(year);
        }
    }

}
