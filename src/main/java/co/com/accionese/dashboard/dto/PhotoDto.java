package co.com.accionese.dashboard.dto;

/**
 *
 * @author janez
 */
public class PhotoDto {

    private String name;

    public PhotoDto(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
