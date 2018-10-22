package co.com.accionese.dashboard.dto.apexcharts;

import java.util.List;

/**
 *
 * @author janez
 */
public class Serie {

    private String name;
    private List<Double> data;

    public Serie() {
    }

    public Serie(String name, List<Double> data) {
        this.name = name;
        this.data = data;
    }

    public List<Double> getData() {
        return data;
    }

    public String getName() {
        return name;
    }

}
