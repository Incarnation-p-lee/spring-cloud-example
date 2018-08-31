package example.kafka.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private MessageProducer sender;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getMessage() {
        this.sender.sendHello();

        return "Message :" + "";
    }
}
