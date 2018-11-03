package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.BaseQueryBuilder;
import co.com.accionese.dashboard.api.GenericRequest;
import co.com.accionese.dashboard.api.IBaseRequest;
import co.com.accionese.dashboard.dto.EvolutiveInvestmentDto;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author janez
 */
@Service
public class TotalInversment extends BaseQueryBuilder implements IBaseRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public BaseResponse genericQuery(Map<String, String> params) {
        return super.genericQuery(this, params);
    }

    @Override
    public void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "TOTAL_INV");
    }

    @Override
    public void buildResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {
        List<Integer> categories = new ArrayList<>();

        Map<String, Long> values = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            String key = content.getYear();

            if (values.containsKey(key)) {
                Long value = values.get(key) + Long.parseLong(content.getCost());
                values.put(key, value);
            } else {
                Long value = Long.parseLong(content.getCost());
                values.put(key, value);
            }
            buildCategories(categories, Integer.parseInt(content.getYear()));
        }

        List<Long> series = buildNumericSerie(values);
        baseResponse.setNumericCategories(categories);
        baseResponse.setNumericSeries(series);
    }
    
    private List<Long> buildNumericSerie(Map<String, Long> values) {
        List<Long> response = new ArrayList<>();
        for (Map.Entry<String, Long> entry : values.entrySet()) {            
            Long value = entry.getValue();
            
            response.add(value);
        }
        return response;
    }

    private void buildCategories(List<Integer> categories, Integer year) {
        if (!categories.contains(year)) {
            categories.add(year);
        }
    }

}
