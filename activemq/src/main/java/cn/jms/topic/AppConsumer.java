package cn.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Demo class
 * @author sunshine
 * Created by sunshine on 2018/9/17.
 */
public class AppConsumer {

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
        MessageConsumer messageConsumer=session.createConsumer(destination);
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                 TextMessage message2= (TextMessage) message;
                try {
                    System.out.println("接收"+message2.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        session.close();

    }

}
