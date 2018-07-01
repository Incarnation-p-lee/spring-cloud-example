package example.feign.consumer;

import example.hello.service.api.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("HELLO-SERVICE")
public interface FeignHelloService extends HelloService {
}
