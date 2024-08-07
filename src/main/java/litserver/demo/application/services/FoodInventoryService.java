package litserver.demo.application.services;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import litserver.demo.infrastructure.repositories.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class FoodInventoryService {

    @Autowired
    private IFoodRepository foodRepository;

    public Page<Food> getAllFoodGrouped(int page, int size, String sortBy, String orderBy) throws NoSuchFieldException {

        Pageable pageable = validatingDirection(page, size, orderBy);

        if (
                sortBy.equals("quantity")
            || sortBy.equals("discount_percent")
            || sortBy.equals("discount_price")
            || sortBy.equals("id")
        ) {
            return foodRepository.findAllSorted(pageable, sortBy);
        }
        else if (
                sortBy.equals("brand")
            || sortBy.equals("expiration_date")
            || sortBy.equals("net-price")
            || sortBy.equals("produced-date")
            || sortBy.equals("type_name")
        ) {
            return foodRepository.findAllSortedByFoodItem(pageable, sortBy);
        }
        else if (sortBy.equals("food_condition"))
        {
            return foodRepository.findAllSortedByFoodCondition(pageable, sortBy);
        }
        else{
            throw new NoSuchFieldException("Not defined");
        }
    }

    public int getTotalAmountFromInventory(){
        return foodRepository.getTotalAmountFromInventory();
    }

    public Pageable validatingDirection(int page, int size ,String orderBy) throws NoSuchFieldException {
        Sort.Direction direction;
        if(orderBy.equals("DESC")){
            direction = Sort.Direction.DESC;
        }
        else if(orderBy.equals("ASC")) {
            direction = Sort.Direction.ASC;
        }else
        {
            throw new NoSuchFieldException("No order like that...");
        }

        return PageRequest.of(page, size, direction);
    }
}
