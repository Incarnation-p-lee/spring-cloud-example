package example.stream.integration.sender;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Order {

    String ORDER_INPUT = "orderInput";
    String ORDER_OUTPUT = "orderOutput";

    @Input(ORDER_INPUT)
    SubscribableChannel inputOrder();

    @Output(ORDER_OUTPUT)
    MessageChannel outputOrder();
}
