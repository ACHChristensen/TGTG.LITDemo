package litserver.demo.infrastructure.repositories;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IFoodRepository extends CrudRepository<Food, Integer> {

    @Query("SELECT SUM(f.quantity) FROM Food f")
    int getTotalAmountFromInventory();

    @Query("SELECT f FROM Food f ORDER BY :#{#sortBy}")
    Page<Food> findAllSorted(@Param("sortBy") String sortBy, Pageable pageable);

    @Query("SELECT fi.foodGroup FROM FoodItem fi ORDER BY :#{#sortBy}")
    Page<Food> findAllSortedByFoodItem(@Param("sortBy") String sortBy, Pageable pageable);

    @Query("SELECT fc.foodGroup FROM FoodCondition fc ORDER BY :#{#sortBy}")
    Page<Food> findAllSortedByFoodCondition(@Param("sortBy") String sortBy, Pageable pageable);
}
