package org.example.springboot.demos.web.service.impl;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl {
    @Autowired
    private RedissonClient redissonClient;
    public void exeTest() {
        RLock lock = redissonClient.getLock("myLock");
        try {
            // 尝试获取锁并设置最大持有时间为10秒
            if (lock.tryLock(5, 10, TimeUnit.SECONDS)) {
                System.out.println("Task started");

                // 模拟任务执行
                Thread.sleep(10000);

                System.out.println("Task finished");
            } else {
                System.out.println("有其他线程执行该任务，请等待");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
