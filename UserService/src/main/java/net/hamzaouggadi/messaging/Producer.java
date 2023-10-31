package net.hamzaouggadi.messaging;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.config.RabbitMqConfig;
import net.hamzaouggadi.entities.AppUser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public void sendAppUser(AppUser appUser) {
        System.out.println("Sending AppUser ...");
        rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME, appUser);
    }
}
