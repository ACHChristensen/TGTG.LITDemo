package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.FoodCondition;
import org.springframework.data.repository.CrudRepository;

public interface IFoodConditionRepository extends CrudRepository<FoodCondition, Integer> {
}
