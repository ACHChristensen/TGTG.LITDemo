package litserver.demo.infrastructure.factories;

import litserver.demo.infrastructure.repositories.IFoodItemRepository;
import litserver.demo.infrastructure.repositories.IFoodRepository;

public record FoodFactory(IFoodItemRepository foodItemRepository, IFoodRepository foodRepository) {

}
