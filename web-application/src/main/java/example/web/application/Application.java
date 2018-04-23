package example.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@EnableEurekaClient
@SpringBootApplication
public class Application {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final static String HELLO_WORLD = "Hello World!";

    @Autowired
    private EurekaDiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {

        final EurekaDiscoveryClient.EurekaServiceInstance instance = client.getInstances("service-discovery");

        log.info(String.format("/hello, host %s, service-id %s", instance.getHost(), instance.getServiceId()));

        return HELLO_WORLD;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
