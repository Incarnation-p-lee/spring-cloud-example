package example.consumer.ribbon;

import com.netflix.hystrix.HystrixInvokableInfo;

import com.netflix.ribbon.hystrix.FallbackHandler;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.Map;

@NoArgsConstructor
public class HelloService {

    private final String serviceUrl = "http://HELLO-SERVICE/hello";

    @Autowired
    private RestTemplate template;

    @Hystrix(fallbackHandler = HelloServiceFallBackHandler.class)
    public String getHelloService() {
        return this.template.getForEntity(this.serviceUrl, String.class).getBody();
    }

    public class HelloServiceFallBackHandler implements FallbackHandler<String> {

        @Override
        public Observable<String> getFallback(HystrixInvokableInfo<?> hystrixInfo, Map<String, Object> requestProperties) {
            return Observable.from(new String[]{"error"});
        }
    }
}
