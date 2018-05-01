package example.web.application;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.logging.Logger;

@RestController
public class Controller {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @SneakyThrows
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloService() {

        final int during = new Random().nextInt(3000);

        LOG.info("Hello Service will last:" + during + "ms");

        Thread.sleep(during);

        return "Say Hello to Service!";
    }
}
