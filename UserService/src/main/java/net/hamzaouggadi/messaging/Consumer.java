package net.hamzaouggadi.messaging;

import net.hamzaouggadi.config.RabbitMqConfig;
import net.hamzaouggadi.entities.AppUser;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void getAppUser(AppUser appUser) {
        System.out.println("Message : AppUser " + appUser);
    }

}
