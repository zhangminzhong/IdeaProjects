package com.server;

import com.datacodec.DataCodecFactory;
import com.sun.javafx.logging.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-4
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
public class MinaTimeServer {
    private static final int PORT= 1234;
    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor(3);
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("mycodec",new ProtocolCodecFilter(new DataCodecFactory()));
        //acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
        acceptor.getFilterChain().addLast("exceutor",new ExecutorFilter());
        acceptor.setHandler(new TimeServerHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("socket server listen:"+PORT);
        //System.out.println(Thread.currentThread().getId());
       /* while (true){
            System.out.println(Thread.activeCount());
        }*/
    }
}
