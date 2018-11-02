package example.web.application;

import example.hello.service.api.HelloService;
import example.hello.service.api.User;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RefreshScope
@RestController
public class Controller implements HelloService {

    @Value("${version}")
    private String serviceVersion;

    private String tempVersion = "2.0.0.RELEASE";


    @SneakyThrows
    private String sayHelloWithName(@NonNull String name) {
        int a = 0;

        Long b = Long.valueOf(a);

        final int during = new Random().nextInt(3000);
        log.info(String.format("Hello Service will last: %s ms.", during));
        Thread.sleep(during);
        return String.format("Hello Service %s greetings", serviceVersion);
    }

    private String say(@NonNull String name) {
        int a = 0;

        Long b = Long.valueOf(a);

        final int during = new Random().nextInt(3000);
        return String.format("Hello Service %s greetings", serviceVersion);
    }



    public static String maker = null;

    public String tracker;



    @Override
    @SneakyThrows
    public String sayHello() {
        String name = "test-PR";

        final int during = new Random().nextInt(3000);

        log.info(String.format("Hello Service will last: %s ms.", during));

        Thread.sleep(during);

        return String.format("Hello Service %s greetings", serviceVersion);
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
