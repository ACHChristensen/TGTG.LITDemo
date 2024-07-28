package litserver.demo.domain.aggregrates.foodaggregate;

import jakarta.persistence.*;


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
    private String note;

    @ManyToOne()
    @JoinColumn(name = "food")
    private FoodItem foodItem;

    @ManyToOne()
    @JoinColumn(name = "food_conditions")
    private FoodCondition foodCondition;

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //TODO - public boolean archeived()
}