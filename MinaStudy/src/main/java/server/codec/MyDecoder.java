package server.codec;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 * Created by AdministratorZhang on 2017/11/1.
 */
public class MyDecoder extends CumulativeProtocolDecoder {
    IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
         while(in.hasRemaining()){
             buffer.put(in.get());
         }
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        buffer.clear();
        String s= new String(bytes, Charset.forName("UTF-8"));
        out.write(s);
        return true;
    }
}
