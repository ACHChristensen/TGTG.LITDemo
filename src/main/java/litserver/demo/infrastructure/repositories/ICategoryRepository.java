package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.FoodCategory;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<FoodCategory, Integer> {
}
