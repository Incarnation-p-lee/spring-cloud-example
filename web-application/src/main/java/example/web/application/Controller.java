package example.web.application;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@Slf4j
public class Controller {

    @SneakyThrows
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloService() {

        final int during = new Random().nextInt(3000);

        log.info("Hello Service will last:" + during + "ms");

        Thread.sleep(during);

        return "Say Hello to Service";
    }

    @RequestMapping(value = "/hello-String", method = RequestMethod.GET)
    public String helloService(@RequestParam String name) {
        return String.format("Say Hello to %s", name);
    }

    @RequestMapping(value = "/hello-User", method = RequestMethod.GET)
    public User helloService(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello-User", method = RequestMethod.POST)
    public String helloService(@RequestBody User user) {
        return String.format("Say Hello to  %s", user.toString());
    }
}
