package litserver.demo.application.dtos;

import litserver.demo.application.dtos.Food.FoodDTO;
import litserver.demo.application.dtos.Food.FoodItemDTO;
import litserver.demo.domain.aggregrates.foodaggregate.Food;
import litserver.demo.domain.aggregrates.foodaggregate.FoodItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    private Model model = new Model();
    public FoodItemDTO convertFoodItemToDto(FoodItem foodItem) {

        ModelMapper modelMapper = model.modelMapper();
        FoodItemDTO foodItemDTO = modelMapper.map(foodItem, FoodItemDTO.class);

        return foodItemDTO;
    }

    public FoodDTO convertFoodGroupToDto(Food foodgroup) {

        ModelMapper modelMapper = model.modelMapper();
        FoodDTO foodDTO = modelMapper.map(foodgroup, FoodDTO.class);
        FoodItemDTO foodItemDTO = convertFoodItemToDto(foodgroup.getFoodItem());
        foodDTO.setFoodItemDTO(foodItemDTO);

        return foodDTO;
    }
}
