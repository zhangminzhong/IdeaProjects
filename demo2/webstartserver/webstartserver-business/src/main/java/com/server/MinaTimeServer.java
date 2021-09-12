package com.server;

import com.serverhandler.TimeServerHandler;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-4
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
public class MinaTimeServer implements Runnable{
    private static final int PORT= 9123;

    public static void main(String[] args) throws IOException {

        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
        //acceptor.getFilterChain().addLast("exceutor",new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptor.setHandler(new TimeServerHandler());

        acceptor.getSessionConfig().setReadBufferSize(2048);
       //acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );

        acceptor.bind(new InetSocketAddress(PORT));
    }

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
        //acceptor.getFilterChain().addLast("exceutor",new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptor.setHandler(new TimeServerHandler());

        acceptor.getSessionConfig().setReadBufferSize(2048);
        //acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );

        try {
            acceptor.bind(new InetSocketAddress(PORT));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
