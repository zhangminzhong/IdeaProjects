package org.whut.mc.server.cluster.worker;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.whut.mc.server.cluster.api.Server;
import org.whut.mc.server.cluster.util.Cmd;
import org.whut.mc.server.core.config.PropConfig;
import org.whut.mc.server.core.log.Log;
import org.whut.mc.server.core.mina.ISocketAcceptor;
import org.whut.mc.server.core.mina.ISocketConnector;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by yangyang on 2016/5/21.
 */
public class PlatformWorker implements Server, Runnable {
        private static Log log;
        private String name;
        private int cPort, aPort;
        private String cIP;

        private static ActiveMQConnection connection;

        static {
            try {
                connection = (ActiveMQConnection) new ActiveMQConnectionFactory(PropConfig.getPropConfig().getString("broker.url")).createConnection();
                connection.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private boolean status;

        private ISocketAcceptor<NioSocketAcceptor> a;
        private ISocketConnector<NioSocketConnector> c;

        public PlatformWorker(String name, String cIP, int aPort, int cPort) {
            this.cPort = cPort;
            this.aPort = aPort;
            this.cIP = cIP;
            status = true;
            this.name = name;
        }
        static {
            log = Log.getLogger(Worker.class);
        }

        @Override
        public void start() {
            c = new ISocketConnector<>(new NioSocketConnector(),
                    new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
            c.init();
            c.connect(cIP, cPort);
            c.send("HandShake," + name + "," + aPort);

            a = new ISocketAcceptor<>(new NioSocketAcceptor(),
                    new PlatformWorkerHandler(),
                    new ProtocolCodecFilter(new HCoderFactory(Charset.forName("UTF-8"))));
            a.bind(aPort);
        }

        @Override
        public void stop() {
            c.send("Close," + name);
            c.destroy();
            a.destroy();
        }

    public void send(Object obj) {
        c.send(obj);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String cmd;
        while (status) {
            cmd = scanner.nextLine();
            if (cmd.equals(Cmd.WORKER_START)) {
                start();
            } else if (cmd.equals(Cmd.WORKER_STOP)) {
                stop();
            } else if (cmd.equals(Cmd.EXIT)) {
                status = false;
            }

        }
    }

    private class PlatformWorkerHandler extends IoHandlerAdapter {

        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {
            log.info("message:{}", message);
            String str = message.toString();

            int type = resolve(str);

            if (type == 1) {
                sendSensor(str);
            } else {
                sendDevice(str);
            }
        }

        private void sendSensor(String msg) throws JMSException {
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session
                    .createProducer(new ActiveMQQueue(Constants.SENSOR_QUEUE_DESTINATION));
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText(msg);
            producer.send(message);
            producer.close();
            session.close();
        }

        public int resolve(String message) throws JMSException {
            int startIndex = message.indexOf("app\":");
            int endIndex = message.indexOf(",",startIndex);
            String app="";
            if(endIndex>startIndex)
            {
                app=message.substring(startIndex+5,endIndex);
                if (app.equals("1")) {
                    return 1;
                } else {
                    return 2;
                }
            }
            return 0;
        }

        private void sendDevice(String s) throws JMSException {
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session
                    .createProducer(new ActiveMQQueue(Constants.DEVICE_QUEUE_DESTINATION));
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText(s);
            producer.send(message);
            producer.close();
            session.close();
        }
    }

    public static void main(String[] args) {
        PlatformWorker worker = new PlatformWorker(
                PropConfig.getPropConfig().getString("worker1.name"),
                PropConfig.getPropConfig().getString("worker1.cIP"),
                PropConfig.getPropConfig().getInt("worker1.aPort"),
                PropConfig.getPropConfig().getInt("worker1.cPort"));
        Thread thread = new Thread(worker);
        thread.start();

    }
}
