package litserver.demo.domain.aggregrates.foodaggregate;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class FoodCategory {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String subCategory;

    @Column()
    private Boolean hasWrittenExpiryDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodCategory", cascade = CascadeType.DETACH)
    private List<FoodItem> foodItems;

    public FoodCategory() {

    }

    public FoodCategory(String name, String subCategory, boolean hasWrittenExpiryDate) {
        this.name = name;
        this.subCategory = subCategory;
        this.hasWrittenExpiryDate = hasWrittenExpiryDate;
        this.foodItems = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public Boolean getHasWrittenExpiryDate() {
        return hasWrittenExpiryDate;
    }

    public void setHasWrittenExpiryDate(Boolean hasWrittenExpiryDate) {
        this.hasWrittenExpiryDate = hasWrittenExpiryDate;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}