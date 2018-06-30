package example.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("HELLO-SERVICE")
public interface HelloService {

    @RequestMapping("/hello")
    String sayHello();

    @RequestMapping(value = "/hello-String", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello-User", method = RequestMethod.GET)
    User sayHello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello-User", method = RequestMethod.POST)
    String sayHello(@RequestBody User user);
}
