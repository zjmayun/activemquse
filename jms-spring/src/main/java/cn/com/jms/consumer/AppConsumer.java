package cn.com.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sunshine  on 2018/9/18.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
    }
}
