package example.web.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloService() {
        return "Say Hello to Service!";
    }
}
