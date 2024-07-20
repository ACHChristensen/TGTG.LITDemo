package litserver.demo.domain.fooditems;

import jakarta.persistence.*;

@Entity
@Table(name = "food_condition")
public class FoodCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String condition;

    @Column()
    private String foodRecommendation;

    public Integer getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFoodRecommendation() {
        return foodRecommendation;
    }

    public void setFoodRecommendation(String foodRecommendation) {
        this.foodRecommendation = foodRecommendation;
    }
}