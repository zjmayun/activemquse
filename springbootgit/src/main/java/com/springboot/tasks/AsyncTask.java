package com.springboot.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author  by sunshine on 2018/9/21.
 */
@Component
public class AsyncTask {

    //进行异步调用
//    @Async
    public Future<Boolean> doTask1() throws InterruptedException {     long start=System.currentTimeMillis();
        Thread.sleep(1000);
        long end=System.currentTimeMillis();
        System.out.println("任务1耗时"+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }

    //进行异步调用
//    @Async
    public Future<Boolean> doTask2() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.sleep(300);
        long end=System.currentTimeMillis();
        System.out.println("任务2耗时"+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }

    //进行异步调用
//    @Async
    public Future<Boolean> doTask3() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.sleep(900);
        long end=System.currentTimeMillis();
        System.out.println("任务3耗时"+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }
}
