package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends CrudRepository<Food, Integer> {

}
