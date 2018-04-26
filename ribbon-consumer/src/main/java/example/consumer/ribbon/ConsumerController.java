package example.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private final String serviceUrl = "http://HELLO-SERVICE/hello";

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String sayHello() {
        return restTemplate.getForEntity(this.serviceUrl, String.class).getBody();
    }
}
