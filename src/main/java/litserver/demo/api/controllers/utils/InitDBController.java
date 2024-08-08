package litserver.demo.api.controllers.utils;

import litserver.demo.application.services.utils.DatabaseInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class InitDBController {

//*** ONLY FOR PERSISTING FAKE DATA TO DB ***//

    /*@Autowired
    private DatabaseInit databaseInit;

    @GetMapping(path = "/initdb/{foodTypesAmount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFood(@PathVariable int foodTypesAmount) {

        String message;
            Long DBamount = databaseInit.populate(foodTypesAmount);
            message = " - SUCCES! " + DBamount + " food types with different random amount has been created !";
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);


    }*/

}
