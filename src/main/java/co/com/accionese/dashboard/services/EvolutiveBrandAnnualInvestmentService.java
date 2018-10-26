package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.PentahoService;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author janez
 */
@Service
public class EvolutiveBrandAnnualInvestmentService implements BaseRequest {

    @Autowired
    PentahoService pentahoService;

    @Override
    public BaseResponse genericQuery(MultiValueMap<String, String> params) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            buildQuery(params);
            buildBaseResponse(baseResponse, params);
            baseResponse.setHttpStatus(HttpStatus.OK);
            return baseResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return baseResponse;
        }
    }

    private void buildQuery(MultiValueMap<String, String> params) throws Exception {
        params.add("paramCityParameter", "%");
        params.add("paramTypeParameter", "%");
        params.add("paramBrandParameter", "%");
        params.add("paramBrandParameterArray", "%");

        params.add("path", "/public/Sipex2/Dashboard/Dashboard.cda");
        params.add("dataAccessId", "BrandMonthInvestmentQuery");

        params.add("outputIndexId", "1");
        params.add("pageSize", "0");
        params.add("pageStart", "0");
        params.add("sortBy", "");
        params.add("paramsearchBox", "");
    }

    private void buildBaseResponse(BaseResponse baseResponse, MultiValueMap<String, String> params) throws Exception {
        String response = pentahoService.genericPentahoRequest(params);

        List<String> categories = new ArrayList<>();

        Map<String, List<Double>> seriesMap = new LinkedHashMap<>();
        Map<String, String> seriesMapFix = new LinkedHashMap<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(response);
        JSONArray resultset = (JSONArray) object.get("resultset");
        for (Object o : resultset) {
            JSONArray remoteStr = (JSONArray) o;

            String cat = remoteStr.get(2).toString().substring(0, 3) + " " + remoteStr.get(1).toString();
            buildCategories(categories, cat);

            String key = remoteStr.get(0).toString().replaceAll(" ", "");

            if (seriesMap.containsKey(key)) {
                List<Double> l = seriesMap.get(key);
                double value = Double.parseDouble(remoteStr.get(3).toString());
                l.add(value);
                seriesMap.put(key, l);
            } else {
                List<Double> v = new ArrayList<>();
                v.add(Double.parseDouble(remoteStr.get(3).toString()));
                seriesMap.put(key, v);
            }
            seriesMapFix.put(key.replaceAll(" ", "") + " " + cat, key);

        }
        
        //fixNullableIndex(categories, seriesMapFix, seriesMap);

        List<Serie> series = buildSeriesWithMap(seriesMap);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);
    }

    private void buildCategories(List<String> categories, String city) {
        if (!categories.contains(city)) {
            categories.add(city);
        }
    }

    private void fixNullableIndex(List<String> categories, Map<String, String> seriesMapFix, Map<String, List<Double>> seriesMap) {
        int counter = 0;
        for (String category : categories) {
            for (Map.Entry<String, List<Double>> entry : seriesMap.entrySet()) {
                String key = entry.getKey();
                List<Double> value = entry.getValue();
                String brand = key.replaceAll(" ", "");

                if (!seriesMapFix.containsKey(brand + " " + category)) {
                    value.add(counter, 0.00);
                    seriesMap.put(key, value);
                }
            }
            counter++;
        }
    }

    private List<Serie> buildSeriesWithMap(Map<String, List<Double>> seriesMap) {
        List<Serie> series = new ArrayList<>();

        for (Map.Entry<String, List<Double>> entry : seriesMap.entrySet()) {
            String key = entry.getKey();
            List<Double> value = entry.getValue();

            series.add(new Serie(key, value));
        }

        return series;
    }

}
