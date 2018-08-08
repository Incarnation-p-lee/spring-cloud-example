package example.kafka.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {

    @KafkaListener(topics = "${app.topic.foo}")
    public void process(@Payload String message) {
        log.info("Consumer: " + message);
    }
}
