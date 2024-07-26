package litserver.demo.domain.fooditems;

import jakarta.persistence.*;
import litserver.demo.domain.fooditems.FoodItem;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String subCategory;

    @OneToMany(mappedBy = "category")
    private List<FoodItem> foodItems;

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

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}