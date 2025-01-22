package org.example.springboot.demos.web.controller;

import org.example.springboot.demos.web.service.impl.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private RabbitProducer rabbitProducer;

    @GetMapping("/send")
    public String sendMessage() {
        rabbitProducer.sendMessage("Hello RabbitMQ!");
        return "Message sent!";
    }
}
