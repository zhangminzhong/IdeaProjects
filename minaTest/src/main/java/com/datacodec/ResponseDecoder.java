package com.datacodec;

import com.sun.javafx.image.BytePixelSetter;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: zhang_minzhong
 * Date: 16-10-20
 * Time: 下午7:33
 * To change this template use File | Settings | File Templates.
 */
public class ResponseDecoder extends CumulativeProtocolDecoder {
    @Override
    protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        String s = ioBuffer.getString(Charset.forName("utf-8").newDecoder());
        System.out.println("解码器线程id："+Thread.currentThread().getId()+"，名称："+Thread.currentThread().getName());
        protocolDecoderOutput.write(s);
        return true;
    }
}
