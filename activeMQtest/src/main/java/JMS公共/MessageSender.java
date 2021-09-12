package JMS公共;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender {

    // 发送次数
    public static final int SEND_NUM = 10;
    // tcp 地址 服务器器端地址
    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;  // 其值为 "tcp://localhost:61616";
    // 目标地址，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/.jsp中可以查询到发送的mq消息
    public static final String DESTINATION = "myJMS";
    //测试连接使用默认的用户名
    public static final String DEFAULT_USER = ActiveMQConnection.DEFAULT_USER;//默认为null
    //测试连接使用默认的密码
    public static final String DEFAULT_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认为null
    /**
     * 发送消息
     * @param session
     * @param producer
     * @throws Exception
     */
    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 0; i < SEND_NUM; i++) {
            String message = "发送消息第" + (i + 1) + "条";
            TextMessage text = session.createTextMessage(message);
            System.out.println(message);
            producer.send(text);
        }
        //生产者睡眠100s
//      Thread.sleep(100000);
    }

    public static void run() throws Exception {

        Connection connection = null;
        Session session = null;
        try {
            // 1、创建链接工厂
            ConnectionFactory factory = new ActiveMQConnectionFactory(DEFAULT_USER, DEFAULT_PASSWORD, BROKER_URL);
            // 2、通过工厂创建一个连接
            connection = factory.createConnection();
            // 3、启动连接
            connection.start();
            // 4、创建一个session会话
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 5、创建一个消息队列
            Destination destination = session.createQueue(DESTINATION);
            // 6、创建消息生产者
            MessageProducer producer = session.createProducer(destination);
            // 7、设置持久化模式
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //发送消息
            sendMessage(session, producer);
            // 提交会话
            session.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭释放资源
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MessageSender.run();
    }
}