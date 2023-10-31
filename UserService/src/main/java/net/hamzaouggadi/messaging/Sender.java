package net.hamzaouggadi.messaging;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        System.out.println("Sending Message ...");
        rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME, "Hello From The App");
    }
}
