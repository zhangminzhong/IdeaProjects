package 点对点;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zhang_minzhong on 2017/2/28.
 */
public class QueueSend {
    // 发送次数
    public static final int SEND_NUM = 10;
    // tcp 地址 服务器器端地址
    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;  // 其值为 "tcp://localhost:61616";
    // 目标地址，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp中可以查询到发送的mq消息
    public static final String DESTINATION = "myQueue";
    //测试连接使用默认的用户名
    public static final String DEFAULT_USER = ActiveMQConnection.DEFAULT_USER;//默认为null
    //测试连接使用默认的密码
    public static final String DEFAULT_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认为null
    public static void sendMessage(QueueSession session,QueueSender sender){
        for(int i=0;i<SEND_NUM;i++){
            String s = "发送第"+i+"条消息";
            try {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(s);
                System.out.println(textMessage.getText());
                sender.send(textMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
    public static void run(){
        //点对点队列连接
        QueueConnection connection = null;
        //点对点会话Session
        QueueSession session = null;
        try {
            // 1、创建链接工厂
            QueueConnectionFactory factory = new ActiveMQConnectionFactory(DEFAULT_USER,DEFAULT_PASSWORD,BROKER_URL);
            // 2、通过工厂创建一个连接
            connection = factory.createQueueConnection();
            // 3、启动连接
            connection.start();
            // 4、创建一个session会话
            session = connection.createQueueSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 5、创建一个消息队列
            Queue queue = session.createQueue(DESTINATION);
            // 6、创建消息发送者
            QueueSender sender = session.createSender(queue);
            // 设置发送模式
            sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            QueueSend.sendMessage(session,sender);
            session.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(session != null)
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            if(connection != null)
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
        }

    }


    public static void main(String[] args) throws Exception {
        QueueSend.run();
    }
}
