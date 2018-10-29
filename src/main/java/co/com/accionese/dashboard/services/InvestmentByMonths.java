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
public class InvestmentByMonths extends BaseQueryBuilder implements IBaseRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        return super.genericQuery(this, params);
    }

    public void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "INV_ANUAL_TYPE");
    }

    @Override
    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {

        List<String> categories = new ArrayList<>();

        Map<String, List<Long>> values = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            String key = content.getType();

            if (values.containsKey(key)) {
                List<Long> l = values.get(key);
                long value = Long.parseLong(content.getCost());
                l.add(value);
                values.put(key, l);
            } else {
                List<Long> v = new ArrayList<>();
                v.add(Long.parseLong(content.getCost()));
                values.put(key, v);
            }
            buildCategories(categories, content.getMonth().substring(0, 3) + " " + content.getYear());
        }

        List<Serie> series = buildSerieWithMap(values);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);
    }

    private void buildCategories(List<String> categories, String year) {
        if (!categories.contains(year)) {
            categories.add(year);
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

}
