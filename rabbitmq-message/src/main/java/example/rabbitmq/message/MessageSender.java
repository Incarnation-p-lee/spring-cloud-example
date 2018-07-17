package example.rabbitmq.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void sendHello() {
        String content = "say hello -- " + new Date().toString();

        this.rabbitmqTemplate.convertAndSend(Constants.QUEUE_NAME, content);

        log.info("SendHello: " + content);
    }
}
