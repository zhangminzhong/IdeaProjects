package com.iobuffertest;

import org.apache.mina.core.buffer.IoBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: zhang_minzhong
 * Date: 16-10-20
 * Time: 下午7:03
 * To change this template use File | Settings | File Templates.
 */
public class IoBufferTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{11,2,4,6,8,9,7,1,3,5,10,12};
        IoBuffer ioBuffer = IoBuffer.wrap(bytes);
        System.out.println(ioBuffer.position());
        System.out.println(ioBuffer.get());
        System.out.println(ioBuffer.remaining());
        System.out.println(ioBuffer.position());

        boolean bt=ioBuffer.prefixedDataAvailable(1);
        System.out.println(bt);

        System.out.println(ioBuffer.get());
    }
}
