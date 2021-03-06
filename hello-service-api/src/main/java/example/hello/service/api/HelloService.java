package example.hello.service.api;

import org.springframework.web.bind.annotation.*;

public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello();

    @RequestMapping(value = "/hello-name", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello-user", method = RequestMethod.GET)
    User sayHello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello-user", method = RequestMethod.POST)
    String sayHello(@RequestBody User user);
}
