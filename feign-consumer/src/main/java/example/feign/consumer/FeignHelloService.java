package example.feign.consumer;

import example.hello.service.api.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "WEB-APPLICATION", fallback = HelloServiceFallback.class)
public interface FeignHelloService extends HelloService {
}
