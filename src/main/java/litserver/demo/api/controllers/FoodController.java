package litserver.demo.api.controllers;

import litserver.demo.application.dtos.Food.FoodItemDTO;
import litserver.demo.application.dtos.Food.FoodDTO;
import litserver.demo.application.dtos.Model;
import litserver.demo.application.services.FoodInventoryService;
import litserver.demo.domain.aggregrates.foodaggregate.Food;
import litserver.demo.domain.aggregrates.foodaggregate.FoodItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    protected FoodInventoryService foodInventoryService;

    private Model model = new Model();

    @GetMapping(path = "/all-food/{amountPerPage}/{pageNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FoodDTO> getAllFood(@PathVariable int pageNumber, @PathVariable int amountPerPage) {

        List<Food> foodList = foodInventoryService.getAllFoodGrouped(pageNumber, amountPerPage).stream().toList();
        return foodList.stream().map(food -> {
            FoodDTO foodDTO = convertFoodGroupToDto(food);
            return foodDTO;
        }).toList();
    }
    @GetMapping(path = "/inventory-food-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int getFoodTotalAmount() {

        return foodInventoryService.getTotalAmountFromInventory();

    }

    private FoodItemDTO convertFoodItemToDto(FoodItem foodItem) {

        ModelMapper modelMapper = model.modelMapper();
        FoodItemDTO foodItemDTO = modelMapper.map(foodItem, FoodItemDTO.class);

        return foodItemDTO;
    }

    private FoodDTO convertFoodGroupToDto(Food foodgroup) {

        ModelMapper modelMapper = model.modelMapper();
        FoodDTO foodDTO = modelMapper.map(foodgroup, FoodDTO.class);

        return foodDTO;
    }
}
