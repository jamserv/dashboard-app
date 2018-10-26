package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.PentahoService;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import co.com.accionese.dashboard.dto.apexcharts.SerieSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class InvestmentBySupportTypeService implements BaseRequest {

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
        params.add("paramBrandParameter", "%");
        params.add("paramBrandParameterArray", "%");
        params.add("paramMonthParameter", "%");
        params.add("paramMonthParameterArray", "%");
        params.add("paramCityParameter", "%");
        params.add("paramYearParameter", "%");
        params.add("paramYearParameterArray", "%");

        params.add("path", "/public/Sipex2/Dashboard/Dashboard.cda");
        params.add("dataAccessId", "TypeInvestmentQuery");

        params.add("outputIndexId", "1");
        params.add("pageSize", "0");
        params.add("pageStart", "0");
        params.add("sortBy", "");
        params.add("paramsearchBox", "");
    }

    private void buildBaseResponse(BaseResponse baseResponse, MultiValueMap<String, String> params) throws Exception {
        String response = pentahoService.genericPentahoRequest(params);

        List<SerieSimple> serieSimples = new ArrayList<>();        

        JSONParser jsonparser = new JSONParser();
        JSONObject object = (JSONObject) jsonparser.parse(response);
        JSONArray resultset = (JSONArray) object.get("resultset");
        for (Object o : resultset) {
            JSONArray remoteStr = (JSONArray) o;            

            String key = remoteStr.get(0) + "" + remoteStr.get(1);
            serieSimples.add(new SerieSimple(key, Double.parseDouble(remoteStr.get(2).toString())));
        }
        
        List<Serie> r = buildSeries(serieSimples);
        
        baseResponse.setNumericCategories(Arrays.asList(2015, 2016, 2017));
        baseResponse.setSeries(r);        
    }

    private List<Serie> buildSeries(List<SerieSimple> serieSimples) {
        List<Double> setVallas = new ArrayList<>();
        List<Double> setParaderos = new ArrayList<>();
        List<Double> setTransmilenio = new ArrayList<>();

        double vallastotal = 0.00;
        double paraderostotal = 0.00;
        double transmileniototal = 0.00;

        for (SerieSimple simple : serieSimples) {
            if (simple.getName().startsWith("Vallas")) {
                vallastotal += simple.getData();
            } else if (simple.getName().startsWith("Paraderos")) {
                paraderostotal += simple.getData();
            } else if (simple.getName().startsWith("Transmilenio")) {
                transmileniototal += simple.getData();
            }

        }                  
        
        for (SerieSimple simple : serieSimples) {
            if (simple.getName().startsWith("Vallas")) {
                double vallasperc = ((simple.getData() * 100) / vallastotal);
                setVallas.add(vallasperc);
            } else if (simple.getName().startsWith("Paraderos")) {
                double paraderosperc = ((simple.getData() * 100) / paraderostotal);
                setParaderos.add(paraderosperc);
            } else if (simple.getName().startsWith("Transmilenio")) {
                double transmilenioperc = ((simple.getData() * 100) / transmileniototal);
                setTransmilenio.add(transmilenioperc);
            }
        }

        List<Serie> series = new ArrayList<>();

        series.add(new Serie("Vallas", setVallas));
        series.add(new Serie("Paraderos", setParaderos));
        series.add(new Serie("Transmilenio", setTransmilenio));

        return series;

    }

}
