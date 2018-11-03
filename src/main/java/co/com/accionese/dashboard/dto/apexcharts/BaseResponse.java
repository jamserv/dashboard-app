package co.com.accionese.dashboard.dto.apexcharts;

import java.io.Serializable;
import java.util.List;
import org.springframework.http.HttpStatus;

/**
 *
 * @author janez
 */
public class BaseResponse implements Serializable {

    private HttpStatus httpStatus;
    private List<String> categories;
    private List<Integer> numericCategories;
    private List<Serie> series;
    private List<Long> numericSeries;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Integer> getNumericCategories() {
        return numericCategories;
    }

    public void setNumericCategories(List<Integer> numericCategories) {
        this.numericCategories = numericCategories;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public List<Long> getNumericSeries() {
        return numericSeries;
    }

    public void setNumericSeries(List<Long> numericSeries) {
        this.numericSeries = numericSeries;
    }

}
