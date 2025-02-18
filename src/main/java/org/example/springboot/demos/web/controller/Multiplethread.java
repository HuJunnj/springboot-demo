package org.example.springboot.demos.web.controller;

import org.example.springboot.demos.web.thread.TreadDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping("/thread")
public class Multiplethread {
   private ThreadPoolExecutor threadPoolExecutor;
    @GetMapping("/start")
    public String startThread(){
        this.threadPoolExecutor =
                 new ThreadPoolExecutor(
                2,          // 核心线程数
                4,          // 最大线程数
                60,         // 线程空闲时的最大存活时间
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), // 阻塞队列
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );
        return "启动线程池成功";
    }
    @GetMapping("/summitTask")
    public String summitTask(){
        TreadDemo treadDemo = new TreadDemo();
        this.threadPoolExecutor.execute(treadDemo);
        return "向线程池提交任务成功";
    }
    @GetMapping("/endThread")
    public String endThread(){
        this.threadPoolExecutor.shutdown();
        return "关闭线程池成功";
    }

}
