package litserver.demo.api.controllers;

import litserver.demo.application.dtos.DTOConverter;
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

    @Autowired
    public DTOConverter dtoConverter;

    //User Story - (subtask): Employees can access a full list of food with expiration dates, ID, type, or brand, displaying all relevant details.
    //User Story - (subtask): Employees can access a list of food and order by expiration dates, ID, type, or brand, displaying all relevant details.
    @GetMapping(path = "/all-food/{amountPerPage}/{pageIndex}/{sortByDetail}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FoodDTO> getAllFood(@PathVariable int pageIndex, @PathVariable int amountPerPage,
                                    @PathVariable String sortByDetail, @RequestParam(defaultValue = "ASC") String orderBy) {
        try {
            List<Food> foodList = foodInventoryService.getAllFoodGrouped(pageIndex, amountPerPage, sortByDetail, orderBy).getContent();

            return foodList.stream().map(food -> {
                FoodDTO foodDTO = dtoConverter.convertFoodGroupToDto(food);
                return foodDTO;
            }).toList();

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/inventory-food-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int getFoodTotalAmount() {

        return foodInventoryService.getTotalAmountFromInventory();
    }


}
