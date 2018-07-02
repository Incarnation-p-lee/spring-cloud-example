package example.feign.consumer;

import example.hello.service.api.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequestMapping("/fallback") // Rewrite interface RequestMapping
public class HelloServiceFallback implements FeignHelloService {

    @Override
    public String sayHello() {
        return "Oops, error occurs when say Hello";
    }

    @Override
    public String sayHello(@RequestParam String name) {
        return String.format("Oops, error occurs when say Hello to %s", name);
    }

    @Override
    public User sayHello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User("Unknown", 0);
    }

    @Override
    public String sayHello(@RequestBody User user) {
        return String.format("Oops, error occurs when say Hello to %s", user.toString());
    }
}
