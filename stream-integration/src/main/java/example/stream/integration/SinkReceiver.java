package example.stream.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.lang.NonNull;

/*
 * @EnableBinding: for one or more interface that defines @Input or @output. In this way,
 *                 we can bind the message channel easily. Here we bind a channel named
 *                 "input".
 *
 * The stream also provide the default @Output channel interface called Source, as well as
 * the Processor interface include @Input and @Output.
 *
 * @StreamListener: registry the method as data stream event listener in messaging
 *                  middleware. With channel name in value.
 */

@Slf4j
@EnableBinding(Sink.class)
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(@NonNull Object payload) {
        log.info("Received: {}", payload.toString());
    }
}
