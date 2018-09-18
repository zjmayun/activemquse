package cn.com.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sunshine
 * on 2018/9/18.
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service=context.getBean(ProducerService.class);
        int length=100;
        for(int i=0;i<length;i++){
            service.sendMessage("test"+i);
        }
        //连接记得关闭
        context.close();
    }
}
