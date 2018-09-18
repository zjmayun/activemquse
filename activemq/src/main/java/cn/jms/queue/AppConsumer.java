package cn.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Demo class
 * @author sunshine
 * Created by sunshine on 2018/9/17.
 */
public class AppConsumer {

    private static final String URL="tcp://127.0.0.1:61616";
    private static final String QUEUE_NAME="queue_test";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(URL);
        //创建一个新的连接
        Connection connection=connectionFactory.createConnection();
        //开启连接
        connection.start();
        //新建一个会话
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createQueue(QUEUE_NAME);
        MessageConsumer messageConsumer=session.createConsumer(destination);
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                 TextMessage message1= (TextMessage) message;
                try {
                    System.out.println("接收"+message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        session.close();

    }

}
