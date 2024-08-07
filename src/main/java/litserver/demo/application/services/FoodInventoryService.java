package litserver.demo.application.services;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import litserver.demo.infrastructure.repositories.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FoodInventoryService {

    @Autowired
    private IFoodRepository foodRepository;

    public Page<Food> getAllFoodGrouped(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return foodRepository.findAll(pageable);
    }

    public int getTotalAmountFromInventory(){
        return foodRepository.getTotalAmountFromInventory();
    }
}
