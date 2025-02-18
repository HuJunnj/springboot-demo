package org.example.springboot.demos.web.config;

import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.Redisson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        // 单节点模式
        config.useSingleServer().setAddress("redis://localhost:6379");
        // Redisson 客户端
        return Redisson.create(config);
    }
}

