package org.whut.mc.server.cluster.master;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.whut.mc.server.cluster.api.Server;
import org.whut.mc.server.cluster.util.Cmd;
import org.whut.mc.server.cluster.util.Info;
import org.whut.mc.server.core.communication.Request;
import org.whut.mc.server.core.config.PropConfig;
import org.whut.mc.server.core.log.Log;
import org.whut.mc.server.core.mina.ISocketAcceptor;

import java.net.InetSocketAddress;
import java.util.*;

/**
 * Created by yangyang on 16-1-27.
 */
public class Master implements Server, Runnable {
    private static Log log;
    private boolean status;
    private static List<Info> infos;
    private static List<Integer> indexs;
    private Timer timer;
    private boolean timer_status = true;
    private Info best;

    private ISocketAcceptor<NioSocketAcceptor> acceptor;
    private int port;
    public Master(int port) {
        this.port = port;
        status = true;
    }

    {
        infos = new ArrayList<>();
        indexs = new ArrayList<>();
    }

    static {
        log = Log.getLogger(Master.class);
    }

    @Override
    public void start() {
        acceptor = new ISocketAcceptor<>(new NioSocketAcceptor(),
                new MasterHandler(),
                new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        acceptor.init();
        acceptor.bind(port);
    }

    @Override
    public void stop() {
        acceptor.destroy();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String cmd;
        while (status) {
            cmd = scanner.nextLine();
            if (cmd.equals(Cmd.MASTER_START)) {
                start();
                timer = new Timer();
                timer.schedule(new MasterTask(), 0, 10 * 1000);
                log.info("master start!");
            } else if (cmd.equals(Cmd.MASTER_STOP)) {
                timer_status = false;
                timer.cancel();
                stop();
                log.info("master stop!");
            } /*else if (cmd.equals(Cmd.MASTER_TIMER_START)) {
                timer = new Timer();
                timer.schedule(new MasterTask(), 0, 10 * 1000);
            }*/ else if (cmd.equals(Cmd.BEST_NODE)) {
                for (Info info : infos) {
                    log.info("worker info: {}, {}", info.getName(), info.getLd());
                }
                if (best != null) {
                    log.info("best node:{}", best.getName());
                } else {
                    log.info("best node is null!");
                }
            } /*else if (cmd.equals(Cmd.MASTER_TIMER_STOP)) {
                timer_status = false;
                timer.cancel();
            }*/ else if (cmd.equals(Cmd.EXIT)) {
                status = false;
            }

        }
    }

    public static void main(String[] args) {
        Master master = new Master(PropConfig.getPropConfig().getInt("master.port"));
        Thread thread = new Thread(master);
        thread.start();
    }

    public static class MasterHandler extends IoHandlerAdapter {
        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {

            String msgStr = message.toString();
            String[] kvs = msgStr.split(",");
            boolean flag = false;
            int i = 0;
            if (kvs[0].equals("HandShake")) {
                for (Info infoTmp : infos) {
                    String name = infoTmp.getName();
                    if (name.equals(kvs[1])) {
                        flag = true;
                        log.info("flag:{}", flag);
                        log.info("恢复之前的状态");
                        if (infos.get(i).getRequests() != null) {
                            session.write(infos.get(i).getRequests());
                            infos.get(i).setStatus(true);
                        }

                        break;
                    }
                    i++;
                }

                if (!flag) {
                    Info info = new Info();
                    info.setName(kvs[1]);
                    info.setIP(((InetSocketAddress) session.getRemoteAddress()).getHostName());
                    info.setPort(((InetSocketAddress) session.getRemoteAddress()).getPort());
                    info.setDate(new Date());
                    synchronized (this) {
                        infos.add(info);
                    }
                    log.info("register:{}", info.getName());
                }
            } else if (kvs[0].equals("Close")) {
                int j = 0;
                for (Info info : infos) {
                    String name = info.getName();
                    if (name.equals(kvs[1])) {
                        break;
                    }
                    j++;
                }
                log.info("remove:{}", infos.get(j).getName());
                synchronized (this) {
                    infos.remove(j);
                }
            } else {
                if (message instanceof List) {
                    String ip = ((InetSocketAddress) session.getRemoteAddress()).getHostName();
                    int port = ((InetSocketAddress) session.getRemoteAddress()).getPort();
                    int k = 0;
                    for (Info info : infos) {
                        if (info.getIP().equals(ip) && info.getPort() == port) {
                            break;
                        }
                        k++;
                    }
                    infos.get(k).setRequests((List<Request>) message);
                } else if (message instanceof Info) {
                    String name = ((Info) message).getName();
                    int p = 0;
                    for (Info info : infos) {
                        if (info.getName().equals(name)) {
                            break;
                        }
                        p++;
                    }
                    log.info("p:{}",p);
                    if (((Info) message).getRequests() != null) {
                        log.info("status list:{}",((Info) message).getRequests());
                        infos.get(p).setRequests(((Info) message).getRequests());
                    }
                    infos.get(p).setLd(((Info) message).getLd());
                    infos.get(p).setDate(new Date());
                    infos.get(p).setStatus(true);
                }
            }
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
            log.info("{} exceptionCaught: {}", session.getRemoteAddress(), cause.getMessage());
        }
    }

    private class MasterTask extends TimerTask {

        @Override
        public void run() {
            if (timer_status) {
                int tmp = Integer.MAX_VALUE - 1;
                int index = 0;

                for (Info info : infos) {
                    Date now = new Date();
                    long diff = now.getTime() - info.getDate().getTime();
                    if (diff > PropConfig.getPropConfig().getInt("worker.idle")) {
                        indexs.add(index);
                    }
                    index++;
                }
                for (int i : indexs) {
                    synchronized (this) {
                        infos.get(i).setStatus(false);
                    }
                }

                if (infos.isEmpty()) {
                    best = null;
                } else {
                    for (Info info : infos) {
                        if (tmp > info.getLd()) {
                            tmp = info.getLd();
                            best = info;
                        }
                    }
                }
            } else {
                cancel();
            }

        }
    }
}
