package cn.com.jms.producer;

/**
 * @author sunshine
 * Created by sunshine on 2018/9/18.
 */
public interface ProducerService {

    /**
     * 生产者发送消息
     * @param message
     */
    void sendMessage(String message);
}
