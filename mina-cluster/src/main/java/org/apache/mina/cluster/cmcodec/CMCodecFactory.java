package org.apache.mina.cluster.cmcodec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * Client和Master节点之间传输的数据格式转换工厂
 * Created by AdministratorZhang on 2018/2/26.
 */
public class CMCodecFactory implements ProtocolCodecFactory{

    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return new CMEncoder();
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return new CMDecoder();
    }
}
