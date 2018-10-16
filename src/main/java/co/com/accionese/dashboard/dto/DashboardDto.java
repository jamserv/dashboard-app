package co.com.accionese.dashboard.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author janez
 */
public class DashboardDto implements Serializable {

    private String sector;
    private String group;
    private String product;
    private String brand;
    private String advertiser;
    private String central;
    private String bell;
    private String creativity;
    private String city;
    private String provider;
    private String sense;
    private String observations;
    private List<PhotoDto> photos;
    private String initialDt;
    private Double costInThousand;
    private String type;

    public DashboardDto() {
    }

    public DashboardDto(String sector, String group, String product, String brand, String advertiser, String central, String bell, String creativity, String city, String provider, String sense, String observations, List<PhotoDto> photos, String initialDt, Double costInThousand, String type) {
        this.sector = sector;
        this.group = group;
        this.product = product;
        this.brand = brand;
        this.advertiser = advertiser;
        this.central = central;
        this.bell = bell;
        this.creativity = creativity;
        this.city = city;
        this.provider = provider;
        this.sense = sense;
        this.observations = observations;
        this.photos = photos;
        this.initialDt = initialDt;
        this.costInThousand = costInThousand;
        this.type = type;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(String advertiser) {
        this.advertiser = advertiser;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public String getBell() {
        return bell;
    }

    public void setBell(String bell) {
        this.bell = bell;
    }

    public String getCreativity() {
        return creativity;
    }

    public void setCreativity(String creativity) {
        this.creativity = creativity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getSense() {
        return sense;
    }

    public void setSense(String sense) {
        this.sense = sense;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDto> photos) {
        this.photos = photos;
    }

    public String getInitialDt() {
        return initialDt;
    }

    public void setInitialDt(String initialDt) {
        this.initialDt = initialDt;
    }

    public Double getCostInThousand() {
        return costInThousand;
    }

    public void setCostInThousand(Double costInThousand) {
        this.costInThousand = costInThousand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
