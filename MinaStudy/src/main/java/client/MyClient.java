package client;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhang_minzhong on 2017/5/22.
 */
public class MyClient {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i=0;i<400;i++){
            pool.execute(new ClientStart());
        }
        pool.shutdown();
        System.out.println("end");
    }
    static class ClientStart implements Runnable{

        @Override
        public void run() {
            IoConnector connector = new NioSocketConnector();
            connector.getFilterChain().addLast("myLogger",new LoggingFilter());
            connector.getFilterChain().addLast("myCodec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
            connector.setHandler(new MyClientHandler());
            ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 9123));
            future.awaitUninterruptibly();
            System.out.println("连接成功。");
            IoSession session = future.getSession();
            Scanner sc = new Scanner(System.in);
            boolean quit = false;
            while(!quit){
                String str = sc.next();
                if(str.equalsIgnoreCase("quit")){
                    quit = true;
                }
                session.write(str);
            }
            //关闭
        /*if(session!=null){
            if(session.isConnected()){
                session.getCloseFuture().awaitUninterruptibly();
                System.out.println("aaaaaaaa");
            }
            connector.dispose(true);
        }*/
            connector.dispose();
        }
    }
}
