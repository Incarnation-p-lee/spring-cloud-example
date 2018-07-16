package example.rabbitmq.message;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

    @Bean
    public Queue helloQueue() {
        return new Queue(Constants.QUEUE_NAME, true);
    }
}
