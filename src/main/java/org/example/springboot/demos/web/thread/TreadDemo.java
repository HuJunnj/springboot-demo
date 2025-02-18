package org.example.springboot.demos.web.thread;

public class TreadDemo implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+"执行任务完成");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
