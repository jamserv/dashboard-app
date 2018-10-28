package co.com.accionese.dashboard.dto.apexcharts;

import java.util.List;

/**
 *
 * @author janez
 */
public class Serie {

    private String name;
    private List<Long> data;

    public Serie() {
    }

    public Serie(String name, List<Long> data) {
        this.name = name;
        this.data = data;
    }

    public List<Long> getData() {
        return data;
    }

    public String getName() {
        return name;
    }

}
