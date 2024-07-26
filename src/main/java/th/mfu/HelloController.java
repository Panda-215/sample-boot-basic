package th.mfu;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/secure")

public class HelloController {

    @GetMapping("/greet")
    String hello() {
        return "Hello World!";
    }

    String[] validNames = { "panda", "view", "krat" };

    @GetMapping("/hi/{name}")
    ResponseEntity<String> hi(@PathVariable String name) {
        // return ResponseEntity.ok("Hi " + name);
        for (String validName : validNames) {
            if (validName.equals(name))
                return ResponseEntity.ok("Hi " + name);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
