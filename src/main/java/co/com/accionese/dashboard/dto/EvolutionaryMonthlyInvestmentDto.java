package co.com.accionese.dashboard.dto;

/**
 *
 * @author janez
 */
public class EvolutionaryMonthlyInvestmentDto {

    private String type;
    private String datetime;
    private Double amountInK;

    public EvolutionaryMonthlyInvestmentDto() {
    }

    public EvolutionaryMonthlyInvestmentDto(String type, String datetime, Double amountInK) {
        this.type = type;
        this.datetime = datetime;
        this.amountInK = amountInK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getAmountInK() {
        return amountInK;
    }

    public void setAmountInK(Double amountInK) {
        this.amountInK = amountInK;
    }

}
