package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface IFoodItemRepository extends CrudRepository<FoodItem, Integer> {

}
