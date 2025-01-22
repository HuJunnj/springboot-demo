package org.example.springboot.demos.web.middleware;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // 队列
    @Bean
    public Queue queue1() {
        return new Queue("myQueue1", true); // 队列名称和是否持久化
    }

    // 队列
    @Bean
    public Queue queue2() {
        return new Queue("myQueue2", true); // 队列名称和是否持久化
    }

    // 交换机
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("myExchange"); // 交换机名称
    }

    // 绑定队列与交换机
    @Bean
    public Binding binding1(Queue queue1, TopicExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("binding1.my.routing.key"); // 路由键
    }
    // 绑定队列与交换机
    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with("binding2.my.routing.key"); // 路由键
    }
}

