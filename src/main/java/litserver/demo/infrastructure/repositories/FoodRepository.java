package litserver.demo.infrastructure.repositories;

import litserver.demo.application.contracts.IFoodItemRepository;
import litserver.demo.application.contracts.IFoodRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FoodRepository {

    private final IFoodItemRepository foodItemRepository;

    private final IFoodRepository foodRepository;


    public FoodRepository(IFoodItemRepository foodItemRepository, IFoodRepository foodRepository) {
        this.foodItemRepository = foodItemRepository;
        this.foodRepository = foodRepository;
    }

    public IFoodItemRepository getFoodItemRepository() {
        return this.foodItemRepository;
    }

    public IFoodRepository getFoodRepository() {
        return this.foodRepository;
    }
}
