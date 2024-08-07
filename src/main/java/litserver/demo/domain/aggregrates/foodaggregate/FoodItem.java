package litserver.demo.domain.aggregrates.foodaggregate;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "food_items")
public class FoodItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_item_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Date producedDate;

    @Column()
    private Date expirationDate;

    @OneToMany(mappedBy = "foodItem")
    private List<Food> food;

    @Column()
    private String typeName;

    @Column()
    private String subTitle;

    @Column()
    private String brand;

    @Column()
    private float netPrice;

    @ManyToOne
    @JoinColumn(name = "categories")
    private FoodCategory foodCategory;

    public FoodItem() {

    }
    public FoodItem(Date producedDate, Date expirationDate, String typeName, String subTitle, String brand, float netPrice, FoodCategory foodCategory) {
        this.producedDate = producedDate;
        this.expirationDate = expirationDate;
        this.food = new ArrayList<>();
        this.typeName = typeName;
        this.subTitle = subTitle;
        this.brand = brand;
        this.netPrice = netPrice;
        this.foodCategory = foodCategory;
    }

    // TODO pantry_min pantry_tips	pantry_max	pantry_metric	refrigerate_min	refrigerate_max	refrigerate_tips	freeze_min	freeze_max	freeze_tips

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

    public FoodCategory getCategory() {
        return this.foodCategory;
    }

    public void setCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    //TODO   private float getGrossPrice(float netPrice);
    //TODO public Date recommendTimeOverdue()
    //TODO public int DaysBeforeExpirationDate()


}