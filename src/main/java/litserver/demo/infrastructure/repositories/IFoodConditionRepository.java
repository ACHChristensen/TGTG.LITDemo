package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.FoodCategory;
import litserver.demo.domain.aggregrates.foodaggregate.FoodCondition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IFoodConditionRepository extends CrudRepository<FoodCondition, Integer> {

    @Query("SELECT fc FROM FoodCondition fc WHERE fc.hasExpiryDate = true " +
            "AND fc.foodRecommendation = :#{#recommendNote}")
    Optional<FoodCondition> getConditionsWithExpiryDateAndRecommendation(
            @Param("recommendNote")String recommendationNote);
    @Query("SELECT fc FROM FoodCondition fc WHERE fc.hasExpiryDate = false " +
            "AND fc.foodRecommendation = :#{#recommendNote}")
    Optional<FoodCondition> getConditionsWithNOExpiryDateAndRecommendation(
            @Param("recommendNote")String recommendationNote);
}
