package org.apache.mina.cluster.cmcodec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * Client和Master节点之间传输的数据格式解码器
 * Created by AdministratorZhang on 2018/2/26.
 */
public class CMDecoder extends CumulativeProtocolDecoder {

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        int count = in.remaining();
        byte[] bytes = new byte[count];
        for(int i = 0;in.hasRemaining();i++){
            bytes[i] = in.get();
        }
        StringBuffer sb = new StringBuffer();
        //长度为5时可能是Client向Master发起的请求或者Master返回的"error"服务器不可用信息
        if(bytes.length==5){
            for(int i=0;i<bytes.length;i++){
                char c = (char)Byte.toUnsignedInt(bytes[i]);
                sb.append(c);
            }
            out.write(sb.toString());
        }
        //长度为6时是Master返回的可用服务器的"IP:PORT"信息
        if(bytes.length==6){
            for(int i=0;i<4;i++){
                sb.append(String.valueOf(Byte.toUnsignedInt(bytes[i]))+".");
            }
            sb.replace(sb.length()-1,sb.length(),":");
            int high = Byte.toUnsignedInt(bytes[4]);
            int low = Byte.toUnsignedInt(bytes[5]);
            String hStr = Integer.toBinaryString(high);
            String lStr = Integer.toBinaryString(low);
            while(hStr.length()<8){
                hStr = "0"+hStr;
            }
            while (lStr.length()<8){
                lStr = "0"+lStr;
            }
            String s = hStr+lStr;
            int port = Integer.parseInt(s,2);
            sb.append(port);
            //System.out.println(sb.toString());
            out.write(sb.toString());
        }
        return true;
    }
}
