package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.PentahoService;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import co.com.accionese.dashboard.dto.apexcharts.SerieSimple;
import java.util.ArrayList;
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
public class EvolutiveInvestmentBranBySupportTypeService implements BaseRequest {

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
        params.add("paramBrandParameter", "%");
        params.add("paramBrandParameterArray", "%");

        params.add("path", "/public/Sipex2/Dashboard/Dashboard.cda");
        params.add("dataAccessId", "BrandAnnualInvestmentQuery");

        params.add("outputIndexId", "1");
        params.add("pageSize", "0");
        params.add("pageStart", "0");
        params.add("sortBy", "");
        params.add("paramsearchBox", "");
    }

    private void buildBaseResponse(BaseResponse baseResponse, MultiValueMap<String, String> params) throws Exception {
        String response = pentahoService.genericPentahoRequest(params);

        List<SerieSimple> serieSimples = new ArrayList<>();

        Map<String, Integer> categories = new HashMap<>();
        List<String> categoriesList = new ArrayList<>();
        Map<String, Double> map = new HashMap<>();

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(response);
        JSONArray resultset = (JSONArray) object.get("resultset");

        for (Object o : resultset) {
            JSONArray remoteStr = (JSONArray) o;

            String key = remoteStr.get(0).toString().trim() + remoteStr.get(1).toString().trim();
            buildEachCol(map, key, Double.parseDouble(remoteStr.get(3).toString()));

            categories.put(remoteStr.get(2).toString().trim(), 0);

            String keyserie = remoteStr.get(2).toString() + key;
            serieSimples.add(new SerieSimple(keyserie, Double.parseDouble(remoteStr.get(3).toString())));
        }

        List<Serie> r = buildSeries(serieSimples, map);

        for (Map.Entry<String, Integer> entry : categories.entrySet()) {
            String key = entry.getKey();
            categoriesList.add(key);
        }

        baseResponse.setCategories(categoriesList);
        baseResponse.setSeries(r);

    }

    private void buildEachCol(Map<String, Double> map, String key, Double newValue) {
        if (map.containsKey(key)) {
            double value = map.get(key);
            map.put(key, (value + newValue));
        } else {
            map.put(key, newValue);
        }
    }

    private List<Serie> buildSeries(List<SerieSimple> serieSimples, Map<String, Double> map) {
        List<Double> setVallas = new ArrayList<>();
        List<Double> setParaderos = new ArrayList<>();
        List<Double> setTransmilenio = new ArrayList<>();
        Map<String, String> brandTypeMap = new HashMap<>();

        for (SerieSimple simple : serieSimples) {
            brandTypeMap.put(simple.getName(), "-");
            if (simple.getName().startsWith("Vallas")) {
                String name = simple.getName().subSequence(6, simple.getName().length()).toString();
                boolean contain = map.containsKey(name);
                if (contain) {
                    double total = map.get(name);
                    double vallasperc = ((simple.getData() * 100) / total);
                    setVallas.add(vallasperc);
                }
            } else if (simple.getName().startsWith("Paraderos")) {
                String name = simple.getName().subSequence(9, simple.getName().length()).toString();
                boolean contain = map.containsKey(name);
                if (contain) {
                    double total = map.get(name);
                    double vallasperc = ((simple.getData() * 100) / total);
                    setParaderos.add(vallasperc);
                }
            } else if (simple.getName().startsWith("Transmilenio")) {
                String name = simple.getName().subSequence(12, simple.getName().length()).toString();
                boolean contain = map.containsKey(name);
                if (contain) {
                    double total = map.get(name);
                    double vallasperc = ((simple.getData() * 100) / total);
                    setTransmilenio.add(vallasperc);
                }
            }
        }
        verifyNullValues(map, brandTypeMap, setVallas, setParaderos, setTransmilenio);

        List<Serie> series = new ArrayList<>();

        series.add(new Serie("Vallas", setVallas));
        series.add(new Serie("Paraderos", setParaderos));
        series.add(new Serie("Transmilenio", setTransmilenio));

        return series;

    }

    private void verifyNullValues(Map<String, Double> map, Map<String, String> brandTypeMap, List<Double> setVallas, List<Double> setParaderos, List<Double> setTransmilenio) {
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();

            if (!brandTypeMap.containsKey("Vallas" + key)) {
                setVallas.add(0.00);
            }
            if (!brandTypeMap.containsKey("Paraderos" + key)) {
                setParaderos.add(0.00);
            }
            if (!brandTypeMap.containsKey("Transmilenio" + key)) {
                setTransmilenio.add(0.00);
            }

        }
    }

}
