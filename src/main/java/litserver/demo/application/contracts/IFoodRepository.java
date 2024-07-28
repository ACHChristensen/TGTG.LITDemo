package litserver.demo.application.contracts;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import org.springframework.data.repository.CrudRepository;

public interface IFoodRepository extends CrudRepository<Food, Integer> {

}
