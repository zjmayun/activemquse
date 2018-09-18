package cn.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Demo class
 * @author sunshine
 * Created by sunshine on 2018/9/17.
 */
public class AppProducer {

    private static final String URL="tcp://127.0.0.1:61616";
    private static final String TOPIC_NAME="topic_test";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(URL);
        //创建一个新的连接
        Connection connection=connectionFactory.createConnection();
        //开启连接
        connection.start();
        //新建一个会话
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createTopic(TOPIC_NAME);
        //消息的生产者
        MessageProducer messageProducer=session.createProducer(destination);
        int length=100;
        for(int i=0;i<length;i++){
            TextMessage textMessage=session.createTextMessage("message"+i);
            messageProducer.send(textMessage);
            System.out.println(textMessage.getText());
        }
        //释放资源
        connection.close();
    }

}
