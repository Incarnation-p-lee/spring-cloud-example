package example.rabbitmq.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = Constants.QUEUE_NAME)
public class MessageReceiver {

    @RabbitHandler
    public void process(String message) {
        log.info("Receiver: " + message);
    }
}
