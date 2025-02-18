package org.example.springboot.demos.web.controller;

import org.example.springboot.demos.web.service.impl.RabbitProducer;
import org.example.springboot.demos.web.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisServiceImpl redisService;
    @GetMapping("/runTask")
    public void executeTest() {
        redisService.exeTest();
    }
}
