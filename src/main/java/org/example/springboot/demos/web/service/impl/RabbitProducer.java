package org.example.springboot.demos.web.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("myExchange", "binding1.my.routing.key", message); // 发送到交换机
        amqpTemplate.convertAndSend("myExchange", "binding2.my.routing.key", message); // 发送到交换机
        amqpTemplate.convertAndSend("myExchange", "binding2.my.routing.key", message); // 发送到交换机
    }
}
