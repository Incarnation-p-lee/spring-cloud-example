package example.feign.consumer;

import example.hello.service.api.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "HELLO-SERVICE", fallback = HelloServiceFallback.class)
public interface FeignHelloService extends HelloService {
}
