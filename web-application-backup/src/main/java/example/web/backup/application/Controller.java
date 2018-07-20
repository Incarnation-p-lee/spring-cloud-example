package example.web.backup.application;

import example.hello.service.api.HelloService;
import example.hello.service.api.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
public class Controller implements HelloService {

    @Value("${location}")
    private String serviceLocation;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return String.format("Hello Service from %s greetings" , serviceLocation);
    }

    @Override
    public String sayHello(@RequestParam String name) {
        return String.format("Say Hello to %s", name);
    }

    @Override
    public User sayHello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @Override
    public String sayHello(@RequestBody User user) {
        return String.format("Say Hello to %s", user.toString());
    }
}
