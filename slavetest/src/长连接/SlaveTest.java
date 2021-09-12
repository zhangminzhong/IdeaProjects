package 长连接;

import org.apache.mina.cluster.slave.Slave;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by AdministratorZhang on 2017/11/23.
 */
public class SlaveTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SlaveTest.class);
    private static int port = 60005;
    public static void main(String[] args) throws InterruptedException, IOException {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("log",new LoggingFilter());
        acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
        acceptor.getFilterChain().addLast("executor",new ExecutorFilter());
        acceptor.setHandler(new IoHandlerAdapter() {
            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                LOGGER.info("slave receive client:" + message.toString());
                Thread.sleep(800);
                session.write("OK");
            }
        });
        acceptor.bind(new InetSocketAddress(port));
        LOGGER.info("server is listening at " + port);
        Slave slave = new Slave();//创建Slave节点
        slave.add(acceptor);//关联服务器
        slave.start();//启动Slave节点
    }
}
