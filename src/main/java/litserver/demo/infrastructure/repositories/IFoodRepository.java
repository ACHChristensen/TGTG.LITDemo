package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import litserver.demo.domain.aggregrates.foodaggregate.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends PagingAndSortingRepository<Food, Integer>, CrudRepository<Food, Integer> {

    @Query("SELECT SUM(f.quantity) FROM Food f")
    int getTotalAmountFromInventory();
}
