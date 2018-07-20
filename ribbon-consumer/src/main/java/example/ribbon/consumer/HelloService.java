package example.ribbon.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
@NoArgsConstructor
public class HelloService {

    private final String serviceUrl = "http://WEB-APPLICATION/hello";

    @Value("${provider.name}")
    private String providerName;

    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "getHelloServiceFallBack")
    public String getHelloService() {
        final String boday = this.template.getForEntity(this.serviceUrl, String.class).getBody();

        return String.format("%s -- provided by %s.", boday, this.providerName);
    }

    public String getHelloServiceFallBack() {
        return String.format("Oops, error occurs in Hello Services -- provided by %s.", this.providerName);
    }
}
