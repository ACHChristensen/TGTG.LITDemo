package litserver.demo.domain.aggregrates.foodaggregate;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "food_conditions")
public class FoodCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_condition_id", nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String foodCondition;

    @Column()
    private String foodRecommendation;

    @OneToMany(mappedBy = "foodCondition")
    private List<Food> food;

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


}