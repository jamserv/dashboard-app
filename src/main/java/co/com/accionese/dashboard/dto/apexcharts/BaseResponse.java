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

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setNumericCategories(List<Integer> numericCategories) {
        this.numericCategories = numericCategories;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

}
