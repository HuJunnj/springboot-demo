package org.example.springboot.demos.web.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {
    @RabbitListener(queues = "myQueue2")
    public void receiveMessage(String message) {
        System.out.println("Email Service Received message: " + message);
    }
}
