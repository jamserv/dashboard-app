package co.com.accionese.dashboard.services;

import co.com.accionese.dashboard.api.PentahoService;
import co.com.accionese.dashboard.dto.apexcharts.BaseResponse;
import co.com.accionese.dashboard.dto.apexcharts.Category;
import co.com.accionese.dashboard.dto.apexcharts.Serie;
import co.com.accionese.dashboard.dto.apexcharts.SerieSimple;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
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
public class EvolutiveInvestmentInMonthsService implements Dashboard {

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

    void solrAproximations() {
        BaseResponse baseResponse = new BaseResponse();
        List<String> categories = new ArrayList<>();
        List<SerieSimple> serieSimples = new ArrayList<>();

        String urlString = "http://localhost:8983/solr/dashboard-core/";
        SolrClient solr = new HttpSolrClient.Builder(urlString).build();

        SolrQuery query = new SolrQuery();
        //query.setRows(0);
        query.set("fl", "Tipo,FechaInicial,CostoEnMiles");
        //query.setFields("Tipo", "FechaInicial", "CostoEnMiles");
        query.set("q", "FechaInicial:[2015-01-01T00:00:00Z TO NOW]");
        query.setSort("FechaInicial", SolrQuery.ORDER.asc);

        try {
            QueryResponse response = solr.query(query);
            SolrDocumentList results = response.getResults();
            for (SolrDocument doc : results) {
                categories.add(parseDate(doc.get("FechaInicial").toString()));
                serieSimples.add(new SerieSimple(doc.get("Tipo").toString(), Double.parseDouble(doc.get("CostoEnMiles").toString())));

            }
        } catch (SolrServerException ex) {
            Logger.getLogger(DashboardService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DashboardService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EvolutiveInvestmentInMonthsService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            List<Serie> compactSeries = buildSeries(serieSimples);
            baseResponse.setCategories(categories);
            baseResponse.setSeries(compactSeries);
        }
        //return baseResponse;
    }

    private String parseDate(String currentDt) throws java.text.ParseException {
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
        java.util.Date date1 = (java.util.Date) formatter.parse(currentDt);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date date = cal.getTime();

        return formatter2.format(date) + "T00:00:00Z";
    }

}
