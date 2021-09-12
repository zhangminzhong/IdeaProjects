package server;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import server.codec.MyCodecFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

/**
 * Created by zhang_minzhong on 2017/5/22.
 */
public class MyServer {
    private static final int PORT = 9123;
    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("myLogger",new LoggingFilter());
        acceptor.getFilterChain().addLast("myCodec",new ProtocolCodecFilter(new MyCodecFactory()));
        acceptor.getFilterChain().addLast("myExecutor",new ExecutorFilter());
        acceptor.setHandler(new MyServerHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("服务器启动");
    }
}
