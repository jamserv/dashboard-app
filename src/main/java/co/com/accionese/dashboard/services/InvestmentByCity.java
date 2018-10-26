package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.PentahoService;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
public class InvestmentByCity implements BaseRequest {

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
        params.add("paramTypeParameter", "%");
        params.add("paramBrandParameter", "%");
        params.add("paramBrandParameterArray", "%");
        params.add("paramMonthParameter", "%");
        params.add("paramMonthParameterArray", "%");
        params.add("paramYearParameter", "%");
        params.add("paramYearParameterArray", "%");

        params.add("path", "/public/Sipex2/Dashboard/Dashboard.cda");
        params.add("dataAccessId", "CityInvestmentQuery");

        params.add("outputIndexId", "1");
        params.add("pageSize", "0");
        params.add("pageStart", "0");
        params.add("sortBy", "");
        params.add("paramsearchBox", "");
    }

    private void buildBaseResponse(BaseResponse baseResponse, MultiValueMap<String, String> params) throws Exception {
        String response = pentahoService.genericPentahoRequest(params);

        Map<String, Double> citiesMap = new HashMap<>();
        List<String> categories = new ArrayList<>();

        Map<Integer, Double> mapYear = new HashMap<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(response);
        JSONArray resultset = (JSONArray) object.get("resultset");
        for (Object o : resultset) {
            JSONArray remoteStr = (JSONArray) o;

            buildCategories(categories, remoteStr.get(0).toString().trim());

            citiesMap.put(remoteStr.get(0).toString().trim() + remoteStr.get(1).toString(), Double.parseDouble(remoteStr.get(2).toString()));
            sumAmountByYear(mapYear, Integer.valueOf(remoteStr.get(1).toString()), Double.parseDouble(remoteStr.get(2).toString()));

        }
        List<Serie> series = buildSeries(citiesMap, mapYear);
        baseResponse.setCategories(categories);
        baseResponse.setSeries(series);
    }

    private void buildCategories(List<String> categories, String city) {
        if (!categories.contains(city)) {
            categories.add(city);
        }
    }

    private List<Serie> buildSeries(Map<String, Double> citiesMap, Map<Integer, Double> mapYear) {
        List<Double> sets2015 = new ArrayList<>();
        List<Double> sets2016 = new ArrayList<>();
        List<Double> sets2017 = new ArrayList<>();

        Map<String, Double> orderedCityYear = citiesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Double> entry1 : orderedCityYear.entrySet()) {
            String cityYear = entry1.getKey();
            Double totalcity = entry1.getValue();

            if (cityYear.endsWith("2015")) {
                double percentage = ((totalcity * 100) / mapYear.get(2015));
                sets2015.add(percentage);
            } else if (cityYear.endsWith("2016")) {
                double percentage = ((totalcity * 100) / mapYear.get(2016));
                sets2016.add(percentage);
            } else if (cityYear.endsWith("2017")) {
                double percentage = ((totalcity * 100) / mapYear.get(2017));
                sets2017.add(percentage);
            }
        }

        List<Serie> series = new ArrayList<>();

        series.add(new Serie("2015", sets2015));
        series.add(new Serie("2016", sets2016));
        series.add(new Serie("2017", sets2017));

        return series;
    }

    private void sumAmountByYear(Map<Integer, Double> map, Integer year, Double newValue) {
        if (map.containsKey(year)) {
            double value = map.get(year);
            map.put(year, (value + newValue));
        } else {
            map.put(year, newValue);
        }
    }

}
