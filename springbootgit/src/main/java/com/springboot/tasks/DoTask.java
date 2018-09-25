package com.springboot.tasks;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created by sunshine on 2018/9/21.
 */
@RestController
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping(value ="/async")
    public String testAsync() throws Exception {
        Long start=System.currentTimeMillis();
        Future<Boolean> future1=asyncTask.doTask1();
        Future<Boolean> future2=asyncTask.doTask2();
        Future<Boolean> future3=asyncTask.doTask3();

        //需要3个任务全部完成，才能够继续执行
        while (!future1.isDone()||!future2.isDone()||!future3.isDone()){
            if(future1.isDone()&&future2.isDone()&&future3.isDone()){
                break;
            }
        }

        Long end=System.currentTimeMillis();
        String information="总共耗时"+(end-start)+"毫秒";
        return information;
    }

}
