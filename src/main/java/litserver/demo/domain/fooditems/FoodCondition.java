package litserver.demo.domain.fooditems;

import jakarta.persistence.*;

import java.util.List;

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
    private String expireRecommendation;

    @OneToMany(mappedBy = "foodCondition")
    private List<FoodQuantity> foodQuantity;

    public Integer getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getExpireRecommendation() {
        return expireRecommendation;
    }

    public void setExpireRecommendation(String expireRecommendation) {
        this.expireRecommendation = expireRecommendation;
    }
}