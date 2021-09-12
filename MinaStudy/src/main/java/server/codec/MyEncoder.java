package server.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by AdministratorZhang on 2017/11/1.
 */
public class MyEncoder implements ProtocolEncoder{
    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        String s = (String) message+"\n";
        byte[] bytes = s.getBytes("UTF-8");
        IoBuffer buffer = IoBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        out.write(buffer);
    }

    @Override
    public void dispose(IoSession session) throws Exception {
    }
}
