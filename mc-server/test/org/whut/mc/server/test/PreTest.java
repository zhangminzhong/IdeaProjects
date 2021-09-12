package org.whut.mc.server.test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.whut.mc.server.core.codec.FrameCodecFactory;
import org.whut.mc.server.core.communication.Request;
import org.whut.mc.server.core.mina.ISocketAcceptor;

import java.util.concurrent.Executors;

/**
 * Created by yangyang on 2016/5/28.
 */
public class PreTest {
    public static void main(String[] args) {
        ISocketAcceptor<NioSocketAcceptor> acceptor =
                new ISocketAcceptor<>(new NioSocketAcceptor(10),
                        new PreHandler(),
                        new ExecutorFilter(Executors.newCachedThreadPool()),
                        new ProtocolCodecFilter(new FrameCodecFactory(System.getProperty("user.dir") + "/src/parser.xml")));
        acceptor.init();
        acceptor.bind(9988);
    }

    private static class PreHandler extends IoHandlerAdapter {
        @Override
        public void messageReceived(IoSession session, Object message) throws Exception {
            long sDate = System.currentTimeMillis();
            Request request = (Request) message;
            session.write(request.getData());
            long tDate = System.currentTimeMillis();
            System.out.println(tDate - sDate);
        }
    }
}
