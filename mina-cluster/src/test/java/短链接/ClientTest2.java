package 短链接;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.apache.mina.cluster.client.ClientToMaster;

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
 * Created by AdministratorZhang on 2017/11/14.
 */
public class ClientTest2 {
    private static final int N = 500;
    private static final HashMap<Long,Long> map = new HashMap<Long, Long>();
    private static CountDownLatch countDownLatch = new CountDownLatch(N);
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<N;i++){
            connect();
        }
        countDownLatch.await();
        //System.out.println("map.size()="+map.size());
        List<Long> list = new ArrayList<Long>(map.values());
        long total = 0;
        long size = list.size();
        for(int i=0;i<list.size();i++){
            total += list.get(i);
        }
        double average = total * 1.0 / size;
        System.out.println("average response time is " + String.format("%.3f",average) + "ms");
    }
    public static void connect() throws InterruptedException {
        ClientToMaster clientToMaster = new ClientToMaster();
        boolean b = clientToMaster.connectMaster();
        if(b){
            final NioSocketConnector connector = new NioSocketConnector(1);
            connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
            connector.setHandler(new IoHandlerAdapter(){
                @Override
                public void messageReceived(IoSession session, Object message) throws Exception {
                    session.setAttribute("endTime",System.currentTimeMillis());
                    //System.out.println(message);
                    synchronized (map){
                        //System.out.println(countDownLatch.getCount());
                        countDownLatch.countDown();
                        Long endTime = (Long)session.getAttribute("endTime");
                        Long beginTime = (Long)session.getAttribute("beginTime");
                        map.put(session.getId(), endTime - beginTime);
                        connector.dispose();
                    };
                }
            });

            ConnectFuture future = connector.connect(new InetSocketAddress(clientToMaster.getRealIp(),clientToMaster.getRealPort()));
            future.awaitUninterruptibly();
            final IoSession session = future.getSession();

            session.setAttribute("beginTime", System.currentTimeMillis());
            session.write("hello world");
        }
    }
}
