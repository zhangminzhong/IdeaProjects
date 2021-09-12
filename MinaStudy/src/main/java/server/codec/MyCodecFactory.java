package server.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Created by AdministratorZhang on 2017/11/1.
 */
public class MyCodecFactory implements ProtocolCodecFactory {
    private MyEncoder myEncoder;
    private MyDecoder myDecoder;

    public MyCodecFactory() {
        myEncoder = new MyEncoder();
        myDecoder = new MyDecoder();
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return myEncoder;
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return myDecoder;
    }
}
