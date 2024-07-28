package litserver.demo.api.controllers;

import litserver.demo.infrastructure.factories.FoodFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {

    protected final FoodFactory foodFactory;

    public FoodController(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    @GetMapping(path = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFood() {
        return new ResponseEntity<>(foodFactory.foodRepository().findAll(), HttpStatus.ACCEPTED);
    }

}
