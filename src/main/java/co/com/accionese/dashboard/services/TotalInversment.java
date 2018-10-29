package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.GenericRequest;
import co.com.accionese.dashboard.dto.EvolutiveInvestmentDto;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.com.accionese.dashboard.api.IMultiRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author janez
 */
@Service
public class TotalInversment implements IMultiRequest {

    @Autowired
    GenericRequest genericRequest;

    @Override
    public List<BaseResponse> genericQuery(Map<String, String> params) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            buildQuery(params);
            buildBaseResponse(baseResponse, params);
            baseResponse.setHttpStatus(HttpStatus.OK);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    private void buildQuery(Map<String, String> params) throws Exception {
        params.put("operationType", "INV_ANUAL_TYPE");
    }

    private void buildBaseResponse(BaseResponse baseResponse, Map<String, String> params) throws Exception {
        List<Integer> categories = new ArrayList<>();

        Map<String, List<Long>> values = new LinkedHashMap<>();

        List<EvolutiveInvestmentDto> list = genericRequest.get(params);
        for (EvolutiveInvestmentDto content : list) {
            String key = content.getCity();

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
            buildCategories(categories, Integer.parseInt(content.getYear()));
        }

        List<Serie> series = buildSerieWithMap(values);
        baseResponse.setNumericCategories(categories);
        baseResponse.setSeries(series);
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
