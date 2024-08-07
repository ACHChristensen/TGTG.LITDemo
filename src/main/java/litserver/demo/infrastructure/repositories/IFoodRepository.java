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

    @Query("SELECT f FROM Food f ORDER BY #{#sortBy}")
    Page<Food> findAllSorted(Pageable pageable, @Param("sortBy") String sortBy);

    @Query("SELECT f FROM Food f, FoodItem fi WHERE fi = f.foodItem ORDER BY fi.#{#sortBy}")
    Page<Food> findAllSortedByFoodItem(Pageable pageable, @Param("sortBy") String sortBy);

    @Query("SELECT f FROM Food f, FoodCondition fc WHERE f.foodCondition = fc ORDER BY fc.#{#sortBy}")
    Page<Food> findAllSortedByFoodCondition(Pageable pageable, @Param("sortBy") String sortBy);
}
