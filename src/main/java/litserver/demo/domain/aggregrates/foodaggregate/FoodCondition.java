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


    @OneToMany(mappedBy = "foodCondition")
    private List<Food> food;

    public FoodCondition() {

    }

    public FoodCondition(String foodCondition, String foodRecommendation, boolean hasExpiryDate) {
        this.foodCondition = foodCondition;
        this.foodRecommendation = foodRecommendation;
        this.hasExpiryDate = hasExpiryDate;
        this.food = new ArrayList<>();
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

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}