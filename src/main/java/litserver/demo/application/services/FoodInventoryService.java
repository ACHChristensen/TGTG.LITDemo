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

        Pageable pageable = validatingDirection(page, size,sortBy, orderBy);
        System.out.println(sortBy);

        if (
                sortBy.equals("quantity")
            || sortBy.equals("discountPercent")
            || sortBy.equals("discountPrice")
            || sortBy.equals("id")
        ) {
            return foodRepository.findAllSorted( sortBy, pageable);
        }
        else if (
                sortBy.equals("brand")
            || sortBy.equals("expirationDate")
            || sortBy.equals("netPrice")
            || sortBy.equals("producedDate")
            || sortBy.equals("typeName")
        ) {
            return foodRepository.findAllSortedByFoodItem(sortBy, pageable);
        }
        else if (sortBy.equals("foodDondition"))
        {
            return foodRepository.findAllSortedByFoodCondition(sortBy,pageable);
        }
        else{
            throw new NoSuchFieldException("Not defined");
        }
    }

    public int getTotalAmountFromInventory(){
        return foodRepository.getTotalAmountFromInventory();
    }

    public Pageable validatingDirection(int page, int size, String sortBy ,String orderBy) throws NoSuchFieldException {

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

        return PageRequest.of(page, size, direction, sortBy);
    }
}
