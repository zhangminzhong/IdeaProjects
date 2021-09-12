package org.whut.mc.server.cluster.worker;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.json.JSONObject;
import org.whut.mc.server.cluster.api.Server;
import org.whut.mc.server.cluster.util.Cmd;
import org.whut.mc.server.cluster.util.Info;
import org.whut.mc.server.core.codec.FrameCodecFactory;
import org.whut.mc.server.core.communication.Codec;
import org.whut.mc.server.core.communication.Request;
import org.whut.mc.server.core.config.PropConfig;
import org.whut.mc.server.core.log.Log;
import org.whut.mc.server.core.mina.ISocketAcceptor;
import org.whut.mc.server.core.mina.ISocketConnector;
import org.whut.mc.server.core.util.CodecUtil;

import java.util.*;

/**
 * Created by yangyang on 16-2-24.
 */
public class Worker implements Server, Runnable {
    private static Log log;
    private String name;
    private int cPort, aPort;
    private String cIP, xmlConfig;
    private List<Request> requests;
    private int ld;
    private Timer timer;

    private boolean status;
    private boolean timer_status = true;

    private ISocketAcceptor<NioSocketAcceptor> a;
    private ISocketConnector<NioSocketConnector> c;

    public Worker(String name, String cIP, int aPort, int cPort, String xmlConfig) {
        this.cPort = cPort;
        this.aPort = aPort;
        this.cIP = cIP;
        this.xmlConfig = xmlConfig;
        status = true;
        this.name = name;
    }

    {
        requests = new ArrayList<>();
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
                new WorkerHandler(),
                new ProtocolCodecFilter(new FrameCodecFactory(xmlConfig)));
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
                timer = new Timer();
                timer.schedule(new WorkerTask(), 10 * 1000, 10 * 1000);
            } else if (cmd.equals(Cmd.WORKER_STOP)) {
                timer_status = false;
                timer.cancel();
                stop();
            } else if (cmd.equals(Cmd.WORKER_SEND)) {
                log.info("请输入将要发送的信息");
                String msg = scanner.nextLine();
                c.send(msg);
            } /*else if (cmd.equals(Cmd.WORKER_TIMER_START)) {
                timer = new Timer();
                timer.schedule(new WorkerTask(), 0, 10 * 1000);
            } else if (cmd.equals(Cmd.WORKER_TIMER_STOP)) {
                timer_status = false;
                timer.cancel();
            }*/ else if (cmd.equals(Cmd.EXIT)) {
                status = false;
            }

        }
    }

    private class WorkerHandler extends IoHandlerAdapter {
        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {
            Request request = (Request) message;
            requests.add(request);
            request.setSession(session);
            log.info("session: {}, resolver: {}", session, request.getResolver());
            //manager.regstry(session, request);
            Class clazz = Class.forName(request.getResolver());
            Codec codec = (Codec) clazz.newInstance();
            String json = codec.resolve(request.getData());
            log.info("response string: {}", json);
            JSONObject jsonObject = new JSONObject(json);
            byte[] btm = codec.code(jsonObject);
            CodecUtil.showMsg(btm);
            session.write(btm);
        }

        @Override
        public void sessionCreated(IoSession session) throws Exception {
            log.info("{} sessionCreated", session.getRemoteAddress());
        }

        @Override
        public void sessionOpened(IoSession session) throws Exception {
            log.info("{} sessionOpened", session.getRemoteAddress());
        }

        @Override
        public void sessionClosed(IoSession session) throws Exception {
            log.info("{} sessionClosed", session.getRemoteAddress());
        }

        @Override
        public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
            cause.printStackTrace();
            log.info("{} exceptionCaught: {}", session.getRemoteAddress(), cause.getMessage());
        }
    }

    private class WorkerTask extends TimerTask {
        private Info info;

        {
            info = new Info();
            info.setName(name);
            info.setPort(aPort);

        }
        @Override
        public void run() {

//            OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
//            long totalvirtualMemory = osmxb.getTotalSwapSpaceSize();
//            long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
//            Double compare=(Double)(1-freePhysicalMemorySize*1.0/totalvirtualMemory)*100;
            ld = a.getA().getManagedSessionCount();
//            ld += ld + compare / 100;

            info.setLd(ld);
            if (requests.size() > 0 && timer_status) {
                log.info("send info");
                info.setRequests(requests);
            }
            c.send(info);
            if (!timer_status) {
                cancel();
            }

        }
    }

    public static void main(String[] args) {
        String configPath = args[0];
        Worker worker = new Worker(
                PropConfig.getPropConfig().getString("worker1.name"),
                PropConfig.getPropConfig().getString("worker1.cIP"),
                PropConfig.getPropConfig().getInt("worker1.aPort"),
                PropConfig.getPropConfig().getInt("worker1.cPort"),
                configPath);
        Thread thread = new Thread(worker);
        thread.start();

    }
}
