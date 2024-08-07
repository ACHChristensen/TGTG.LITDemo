package litserver.demo.application.dtos.Food;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.sql.Date;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FoodItemDTO {

    private Integer id;

    private Date producedDate;

    private Date expirationDate;

    private String typeName;

    private String subTitle;

    private String brand;

    private float netPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(float netPrice) {
        this.netPrice = netPrice;
    }
}
