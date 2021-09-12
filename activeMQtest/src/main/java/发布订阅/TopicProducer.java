package 发布订阅;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zhang_minzhong on 2017/2/28.
 */
public class TopicProducer {
    // 发送次数
    public static final int SEND_NUM = 10;
    // tcp 地址 服务器器端地址
    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;  // 其值为 "tcp://localhost:61616";
    // 目标地址，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/topics.jsp中可以查询到发送的mq消息
    public static final String DESTINATION = "myTopic";
    //测试连接使用默认的用户名
    public static final String DEFAULT_USER = ActiveMQConnection.DEFAULT_USER;//默认为null
    //测试连接使用默认的密码
    public static final String DEFAULT_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认为null
    public static void sendMessage(TopicSession session,TopicPublisher publisher){
        for(int i=0;i<SEND_NUM;i++){
            String s = "发送第"+i+"条消息";
            try {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(s);
                System.out.println(textMessage.getText());
                publisher.send(textMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
    public static void run(){
        TopicConnection connection = null;
        TopicSession session = null;
        try{
            TopicConnectionFactory factory = new ActiveMQConnectionFactory(DEFAULT_USER,DEFAULT_PASSWORD,BROKER_URL);
            connection = factory.createTopicConnection();
            connection.start();
            session = connection.createTopicSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(DESTINATION);
            TopicPublisher publisher = session.createPublisher(topic);
            publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session, publisher);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session!=null){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        run();
    }
}
