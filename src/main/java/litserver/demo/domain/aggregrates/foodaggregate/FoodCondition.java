package litserver.demo.domain.aggregrates.foodaggregate;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "food_conditions")
public class FoodCondition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_condition_id", nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String foodCondition;

    @Column(nullable = true)
    private String foodRecommendation;

    @Column()
    private Boolean hasExpiryDate;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "foodCondition")
    private List<Food> foodGroup;

    public FoodCondition() {

    }

    public FoodCondition(String foodCondition, String foodRecommendation, boolean hasExpiryDate) {
        this.foodCondition = foodCondition;
        this.foodRecommendation = foodRecommendation;
        this.hasExpiryDate = hasExpiryDate;
        this.foodGroup = new ArrayList<>();
    }
    public Integer getId() {
        return id;
    }

    public String getFoodCondition() {
        return foodCondition;
    }

    public void setFoodCondition(String foodCondition) {
        this.foodCondition = foodCondition;
    }

    public String getFoodRecommendation() {
        return foodRecommendation;
    }

    public void setFoodRecommendation(String foodRecommendation) {
        this.foodRecommendation = foodRecommendation;
    }

    public Boolean getHasExpiryDate() {
        return hasExpiryDate;
    }

    public void setHasExpiryDate(Boolean hasExpiryDate) {
        this.hasExpiryDate = hasExpiryDate;
    }

    public List<Food> getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(List<Food> food) {
        this.foodGroup = food;
    }
}