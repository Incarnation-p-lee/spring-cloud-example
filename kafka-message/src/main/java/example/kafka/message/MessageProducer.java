package example.kafka.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.foo}")
    private String topic;

    public void sendHello() {
        String content = "say hello -- " + new Date().toString();

        this.kafkaTemplate.send(topic, "hello", content);

        log.info("Producer: " + content);
    }
}
