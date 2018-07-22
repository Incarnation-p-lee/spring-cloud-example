package example.feign.consumer;

import example.hello.service.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConsumerController {

    @Value("${consumer.version")
    private String version;

    @Autowired
    private FeignHelloService service;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String sayHello() {
        return String.format("%s of %s", this.service.sayHello(), this.version);
    }

    @RequestMapping(value = "/consumer-user", method = RequestMethod.GET)
    public String sayHelloUser() {
        final StringBuilder builder = new StringBuilder();
        final String separator = "----";

        builder.append(this.service.sayHello()).append(separator);
        builder.append(this.service.sayHello("incarnation")).append(separator);
        builder.append(this.service.sayHello("siqili", 1)).append(separator);
        builder.append(this.service.sayHello(new User("panli", 31)));

        return builder.toString();
    }
}
