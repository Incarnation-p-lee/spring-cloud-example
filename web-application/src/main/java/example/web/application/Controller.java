package example.web.application;

import example.hello.service.api.HelloService;
import example.hello.service.api.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@Slf4j
public class Controller implements HelloService {

    @Override
    @SneakyThrows
    public String sayHello() {

        final int during = new Random().nextInt(3000);

        log.info("Hello Service will last:" + during + "ms");

        Thread.sleep(during);

        return "Say Hello to Service";
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
        return String.format("Say Hello to  %s", user.toString());
    }
}
