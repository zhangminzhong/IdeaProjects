package JMS公共;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zhang_minzhong on 2017/2/27.
 */
public class MessageReceiver_Listener {


    // tcp 地址 服务器器端地址
    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;  // 其值为 "tcp://localhost:61616";
    // 目标地址，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp中可以查询到发送的mq消息
    public static final String DESTINATION = "myJMS";
    //测试连接使用默认的用户名
    public static final String DEFAULT_USER = ActiveMQConnection.DEFAULT_USER;//默认为null
    //测试连接使用默认的密码
    public static final String DEFAULT_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认为null


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
            // 创建消费者
            MessageConsumer consumer = session.createConsumer(destination);

            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message msg) {
                    // 接收相关的消息
                    TextMessage text = (TextMessage) msg;
                    if (text != null) {
                        try {
                            System.out.println("接收：" + text.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            //让当前主线程睡眠10秒，单但是监听器会继续执行
            Thread.sleep(1000*10);
           /*//使用receive方法接收消息
           while (true){
                // 接收数据的时间（等待） 10 s ,超过10秒自动超时
                Message message = consumer.receive(1000*10);
                // 接收相关的消息
                TextMessage text = (TextMessage) message;
                if (text != null) {
                    System.out.println("接收：" + text.getText());
                } else {
                    break;
                }
            }*/
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
        MessageReceiver_Listener.run();
    }
}
