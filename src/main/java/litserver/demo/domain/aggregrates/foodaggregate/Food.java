package litserver.demo.domain.aggregrates.foodaggregate;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer quantity;

    @Column()
    private double discountPrice;

    @Column()
    private double discountPercent;

    @ManyToOne()
    @JoinColumn(name = "food")
    private FoodItem foodItem;

    @ManyToOne()
    @JoinColumn(name = "food_conditions")
    private FoodCondition foodCondition;

    public Food() {

    }
    public Food(Integer quantity, double discountPrice, double discountPercent, FoodItem foodItem, FoodCondition foodCondition) {
        this.quantity = quantity;
        this.discountPrice = discountPrice;
        this.discountPercent = discountPercent;
        this.foodItem = foodItem;
        this.foodCondition = foodCondition;
    }
    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public FoodCondition getFoodCondition() {
        return foodCondition;
    }

    public void setFoodCondition(FoodCondition foodCondition) {
        this.foodCondition = foodCondition;
    }

    //TODO - public boolean archeived()
}