package co.com.accionese.dashboard.dto.apexcharts;

/**
 *
 * @author janez
 */
public class SerieSimple {
    
    private String name;
    private Long data;

    public SerieSimple() {
    }

    public SerieSimple(String name, Long data) {
        this.name = name;
        this.data = data;
    }

    public Long getData() {
        return data;
    }

    public String getName() {
        return name;
    }
    
    
    
}
