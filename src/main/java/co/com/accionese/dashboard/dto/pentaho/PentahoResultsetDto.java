package co.com.accionese.dashboard.dto.pentaho;

/**
 *
 * @author janez
 */
public class PentahoResultsetDto {

    private String type;
    private Integer ano;
    private String month;
    private Double cost;

    public PentahoResultsetDto() {
    }

    public PentahoResultsetDto(String type, Integer ano, String month, Double cost) {
        this.type = type;
        this.ano = ano;
        this.month = month;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
