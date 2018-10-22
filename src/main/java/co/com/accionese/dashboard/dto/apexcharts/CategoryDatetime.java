package co.com.accionese.dashboard.dto.apexcharts;

import java.sql.Timestamp;

/**
 *
 * @author janez
 */
public class CategoryDatetime {

    private Timestamp name;

    public CategoryDatetime() {
    }

    public CategoryDatetime(Timestamp name) {
        this.name = name;
    }

    public Timestamp getName() {
        return name;
    }

}
