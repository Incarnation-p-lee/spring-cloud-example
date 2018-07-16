package example.ribbon.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
public class HelloService {

    private final String serviceUrl = "http://HELLO-SERVICE/hello";

    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "getHelloServiceFallBack")
    public String getHelloService() {
        return this.template.getForEntity(this.serviceUrl, String.class).getBody();
    }

    public String getHelloServiceFallBack() {
        return "Oops, error occurs in Hello Services";
    }
}
