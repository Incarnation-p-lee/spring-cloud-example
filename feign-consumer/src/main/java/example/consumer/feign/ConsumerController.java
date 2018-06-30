package example.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String sayHello() {
        return this.helloService.sayHello();
    }

    @RequestMapping(value = "/consumer-user", method = RequestMethod.GET)
    public String sayHelloUser() {
        final StringBuilder builder = new StringBuilder();
        final String separator = "----";

        builder.append(this.helloService.sayHello()).append(separator);
        builder.append(this.helloService.sayHello("incarnation")).append(separator);
        builder.append(this.helloService.sayHello("siqili", 1)).append(separator);
        builder.append(this.helloService.sayHello(new User("panli", 31)));

        return builder.toString();
    }
}
