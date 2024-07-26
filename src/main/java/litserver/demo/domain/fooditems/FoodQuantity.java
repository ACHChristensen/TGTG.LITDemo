package litserver.demo.domain.fooditems;

import jakarta.persistence.*;


@Entity
@Table(name = "food_quantities")
public class FoodQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_quantity_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer quantiiy;

    @Column()
    private String note;

    @ManyToOne()
    @JoinColumn(name = "food_items")
    private FoodItem foodItem;

    @ManyToOne()
    @JoinColumn(name = "food_conditions")
    private FoodCondition foodCondition;

    public Integer getId() {
        return id;
    }

    public Integer getQuantiiy() {
        return quantiiy;
    }

    public void setQuantiiy(Integer guantiiy) {
        this.quantiiy = guantiiy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //TODO - public boolean archeived()
}