package 长连接;

import org.apache.mina.cluster.client.ClientToMaster;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdministratorZhang on 2017/11/23.
 */
public class ClientTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientTest.class);
    private static final int N = 120;
    private static final HashMap<Long,Long> map = new HashMap<Long, Long>();
    private static CountDownLatch countDownLatch = new CountDownLatch(N);
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<N;i++){
            connect();
        }
        countDownLatch.await();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                List<Long> list = new ArrayList<Long>(map.values());
                long total = 0;
                long size = list.size();
                for(int i=0;i<list.size();i++){
                    total += list.get(i);
                }
                double average = total * 1.0 / size;
                System.out.println("average response time is " + String.format("%.3f",average) + "ms");
            }
        },0,2,TimeUnit.SECONDS);
    }
    public static void connect() throws InterruptedException {
        ClientToMaster client = new ClientToMaster();//创建到Master节点连接
        boolean b = client.connectMaster();
        if(b){//判断是否有可用服务器
            final NioSocketConnector connector = new NioSocketConnector(1);
            if(connector!=null){
                connector.setConnectTimeoutMillis(6000);
                //connector.getFilterChain().addLast("log",new LoggingFilter());
                connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
                connector.setHandler(new IoHandlerAdapter() {
                    @Override
                    public void messageReceived(IoSession session, Object message) throws Exception {
                        session.setAttribute("endTime", System.currentTimeMillis());
                        //LOGGER.info("receive:"+message);
                        synchronized (map) {
                            countDownLatch.countDown();
                            Long endTime = (Long) session.getAttribute("endTime");
                            Long beginTime = (Long) session.getAttribute("beginTime");
                            Long sub = endTime - beginTime;
                            //System.out.println(sub);
                            map.put(session.getId(), sub);
                        }
                    }
                });
                ConnectFuture future = connector.connect(new InetSocketAddress(client.getRealIp(),client.getRealPort()));
                future.awaitUninterruptibly();
                final IoSession session = future.getSession();
                ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
                service.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                        session.setAttribute("beginTime", System.currentTimeMillis());
                        session.write("hello world");
                    }
                }, 0, 1, TimeUnit.SECONDS);
            }
        }
        else{
            System.exit(0);
        }
    }
}
