package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.PentahoService;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Category;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import co.com.accionese.dashboard.dto.apexcharts.SerieSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class EvolutiveInvestmentInMonthsService implements BaseRequest {

    @Autowired
    PentahoService pentahoService;

    @Override
    public BaseResponse genericQuery(MultiValueMap<String, String> params) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            buildQuery(params);
            baseResponse.setSeries(buildSeries(params));
            baseResponse.setCategories(Arrays.asList("Vallas", "Transmilenio", "Paraderos"));
            baseResponse.setHttpStatus(HttpStatus.OK);
            return baseResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return baseResponse;
        }
    }

    private void buildQuery(MultiValueMap<String, String> params) throws Exception {
        params.add("paramBrandParameter", "%");
        params.add("paramBrandParameterArray", "%");
        params.add("paramYearParameter", "%");
        params.add("paramYearParameterArray", "%");
        params.add("paramCityParameter", "%");

        params.add("path", "/public/Sipex2/Dashboard/Dashboard.cda");
        params.add("dataAccessId", "AnnualinvestmentQuery");

        params.add("outputIndexId", "1");
        params.add("pageSize", "0");
        params.add("pageStart", "0");
        params.add("sortBy", "0");
        params.add("paramsearchBox", "");
    }

    private List<Serie> buildSeries(MultiValueMap<String, String> params) throws Exception {
        String response = pentahoService.genericPentahoRequest(params);

        List<SerieSimple> serieSimples = new ArrayList<>();
        Map<String, Category> categories = new HashMap<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(response);
        JSONArray resultset = (JSONArray) object.get("resultset");
        for (Object o : resultset) {
            JSONArray remoteStr = (JSONArray) o;
            String category = remoteStr.get(3).toString() + " " + remoteStr.get(2).toString();
            categories.put(category, new Category(category));

            String key = remoteStr.get(0) + "" + remoteStr.get(2) + "" + remoteStr.get(3);            
            serieSimples.add(new SerieSimple(key, Double.parseDouble(remoteStr.get(4).toString())));
        }
        
        List<Serie> r = buildSeries(serieSimples);

        return r;
    }

    private List<Serie> buildSeries(List<SerieSimple> serieSimples) {
        List<Double> setVallas = new ArrayList<>();
        List<Double> setParaderos = new ArrayList<>();
        List<Double> setTransmilenio = new ArrayList<>();

        Map<String, Double> map = new HashMap<>();
        List<Serie> series = new ArrayList<>();
        for (SerieSimple serieSimple : serieSimples) {
            if (map.containsKey(serieSimple.getName())) {
                double d = map.get(serieSimple.getName()) + serieSimple.getData();
                map.put(serieSimple.getName(), d);

                if (serieSimple.getName().startsWith("Vallas")) {
                    setVallas.remove(setVallas.size() - 1);
                    setVallas.add(d);
                } else if (serieSimple.getName().startsWith("Paraderos")) {
                    setParaderos.remove(setParaderos.size() -1);
                    setParaderos.add(d);
                } else if (serieSimple.getName().startsWith("Transmilenio")) {
                    setTransmilenio.remove(setTransmilenio.size() - 1);
                    setTransmilenio.add(d);
                }
            } else {
                if (serieSimple.getName().startsWith("Vallas")) {
                    setVallas.add(serieSimple.getData());
                } else if (serieSimple.getName().startsWith("Paraderos")) {
                    setParaderos.add(serieSimple.getData());
                } else if (serieSimple.getName().startsWith("Transmilenio")) {
                    setTransmilenio.add(serieSimple.getData());
                }
                map.put(serieSimple.getName(), serieSimple.getData());
            }
        }

        series.add(new Serie("Vallas", setVallas));
        series.add(new Serie("Paraderos", setParaderos));
        series.add(new Serie("Transmilenio", setTransmilenio));

        return series;

    }

}
