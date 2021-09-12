package com.datacodec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: zhang_minzhong
 * Date: 16-10-20
 * Time: 下午7:54
 * To change this template use File | Settings | File Templates.
 */
public class ResponseEncoder extends ProtocolEncoderAdapter {
    @Override
    public void encode(IoSession ioSession, Object o, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        System.out.println("encode方法");
        String s = o.toString();
        byte[] bytes = s.getBytes(Charset.forName("utf-8"));
        IoBuffer ioBuffer = IoBuffer.allocate(bytes.length);

        ioBuffer.put(bytes);
        //System.out.println(ioBuffer.limit());
        ioBuffer.flip();
        protocolEncoderOutput.write(ioBuffer);
    }
}
