package litserver.demo.domain.fooditems;

import jakarta.persistence.*;
import litserver.demo.domain.product.Product;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "food_item")
public class FoodItem extends Product {

    @Column(nullable = false)
    private Date producedDate;

    @Column()
    private Date expirationDate;

    @OneToMany(mappedBy = "foodItem")
    private List<FoodQuantity> foodQuantity;

    // TODO pantry_min pantry_tips	pantry_max	pantry_metric	refrigerate_min	refrigerate_max	refrigerate_tips	freeze_min	freeze_max	freeze_tips

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    //TODO public Date recommendTimeOverdue()
    //TODO public int DaysBeforeExpirationDate()


}