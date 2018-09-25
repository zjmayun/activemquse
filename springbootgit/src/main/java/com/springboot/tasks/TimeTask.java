package com.springboot.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by sunshine on 2018/9/21.
 */
@Component
public class TimeTask {

     private static final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

     //定义一段时间执行
     @Scheduled(cron = "40/10 * * * * ? ")
     public void task(){
         System.out.println("现在时间:"+dateFormat.format(new Date()));
     }
}
