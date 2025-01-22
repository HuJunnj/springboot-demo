package org.example.springboot.demos.web.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {

    @RabbitListener(queues = "myQueue2")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
