package org.example.springboot.demos.web.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AnalysisConsumer {
    @RabbitListener(queues = "myQueue1")
    public void receiveMessage(String message) {
        System.out.println("Analysis Service Received message: " + message);
    }
}
