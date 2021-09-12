package org.apache.mina.cluster.cmcodec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * Client和Master节点之间传输的数据格式编码器
 * Created by AdministratorZhang on 2018/2/26.
 */
public class CMEncoder extends ProtocolEncoderAdapter {
    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        String s = (String) message;
        //对Client发送的"query"编码
        if(s.equals("query")){
            //System.out.println(s);
            byte[] bytes = new byte[5];
            bytes[0] = 113;
            bytes[1] = 117;
            bytes[2] = 101;
            bytes[3] = 114;
            bytes[4] = 121;
            IoBuffer ioBuffer = IoBuffer.wrap(bytes);
            out.write(ioBuffer);
        }
        //对Master返回的"error"编码
        else if(s.equals("error")){
            byte[] bytes = new byte[5];
            bytes[0] = 101;
            bytes[1] = 114;
            bytes[2] = 114;
            bytes[3] = 111;
            bytes[4] = 114;
            IoBuffer ioBuffer = IoBuffer.wrap(bytes);
            out.write(ioBuffer);
        }
        //对Master返回的可用服务器信息"IP:PORT"编码
        else {
            String[] arr1 = s.split(":");
            String[] arr2 = arr1[0].split("\\.");
            byte[] bytes = new byte[6];
            for(int i=0;i<arr2.length;i++){
                bytes[i] = (byte) Integer.parseInt(arr2[i]);
            }
            String bStr = Integer.toBinaryString(Integer.parseInt(arr1[1]));
            while (bStr.length()<16){
                bStr = "0"+bStr;
            }
            bytes[4] = (byte) Integer.parseInt(bStr.substring(0,8),2);
            bytes[5] = (byte) Integer.parseInt(bStr.substring(8),2);
            IoBuffer ioBuffer = IoBuffer.wrap(bytes);
            out.write(ioBuffer);
        }
    }
}
