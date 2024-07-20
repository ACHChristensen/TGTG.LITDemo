//TODO - Only for test - TO BE DELETED !

package litserver.demo.interfaces.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {

    //@CrossOrigin //TODO - NOTE DELETE?
    @GetMapping(path = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity testingHelloHorld() {
         String hellotest = "Hello world";
         return new ResponseEntity<>(hellotest, HttpStatus.ACCEPTED);

    }

    @GetMapping(path = "/nohelloworld", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity testingNoCrossOriginHelloWorld() {
        String hellotest = "No!";
        return new ResponseEntity<>(hellotest, HttpStatus.ACCEPTED);

    }
}
