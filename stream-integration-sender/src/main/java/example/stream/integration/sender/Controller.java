package example.stream.integration.sender;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableBinding({Source.class, Order.class})
public class Controller {

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel output;

    @Autowired
    private Order order;


    @GetMapping("/message")
    public String sendMessage() {
        this.output.send(MessageBuilder.withPayload("From Source Sending Hello").build());
        this.order.outputOrder().send(MessageBuilder.withPayload("From Order Sending Hello").build());

        log.info("All message sent!");

        return "Sender done!";
    }

    @StreamListener(Order.ORDER_INPUT)
    public void receive(@NonNull String load) {
        log.info("Received From Order: {}", load);
    }
}
