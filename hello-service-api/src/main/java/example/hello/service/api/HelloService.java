package example.hello.service.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello();

    @RequestMapping(value = "/hello-String", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello-User", method = RequestMethod.GET)
    User sayHello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello-User", method = RequestMethod.POST)
    String sayHello(@RequestBody User user);
}
