package litserver.demo.api.controllers;

import litserver.demo.infrastructure.repositories.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    protected IFoodRepository foodRepository;
    @GetMapping(path = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFood() {
        return new ResponseEntity<>(foodRepository.findAll(), HttpStatus.ACCEPTED);
    }

}
