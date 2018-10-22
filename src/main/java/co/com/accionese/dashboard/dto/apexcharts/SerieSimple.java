package co.com.accionese.dashboard.dto.apexcharts;

/**
 *
 * @author janez
 */
public class SerieSimple {
    
    private String name;
    private Double data;

    public SerieSimple() {
    }

    public SerieSimple(String name, Double data) {
        this.name = name;
        this.data = data;
    }

    public Double getData() {
        return data;
    }

    public String getName() {
        return name;
    }
    
    
    
}
