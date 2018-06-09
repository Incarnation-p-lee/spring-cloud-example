package example.web.backup.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WebApplicationBackup {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationBackup.class, args);
    }
}
