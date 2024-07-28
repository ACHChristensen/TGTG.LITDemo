package litserver.demo.infrastructure.controllers;

import litserver.demo.infrastructure.repositories.FoodRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {

    protected final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping(path = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFood() {
        return new ResponseEntity<>(foodRepository.getFoodRepository().findAll(), HttpStatus.ACCEPTED);
    }

}
