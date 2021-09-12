package client;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by zhang_minzhong on 2017/6/3.
 */
public class Client {

    public IoConnector creatClient(){
        IoConnector connector=new NioSocketConnector();
        connector.setConnectTimeoutMillis(30000);
        connector.getFilterChain().addLast("logger",new LoggingFilter());
        //ProtocolCodecFactory factory = new PrefixedStringCodecFactory(Charset.forName("unicode"))
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
        connector.setHandler(new MyClientHandler());
        return connector;
    }
    public IoSession getIOSession(IoConnector connector){
        ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 9123));
        // 等待是否连接成功，相当于是转异步执行为同步执行。
        future.awaitUninterruptibly();
        // 连接成功后获取会话对象。 如果没有上面的等待， 由于connect()方法是异步的， session可能会无法获取。
        IoSession session = null;
        try{
            session = future.getSession();
        }catch(Exception e){
            e.printStackTrace();
        }
        return session;
    }
    public void sendMsg(IoSession session,String msg){
        session.write(msg);
    }
    //  public void sendByte(IoSession session,byte[] byteArray,String timeMsg){
//      BaseMessage baseMessage = new BaseMessage();
//      MessageBean msgBean = new MessageBean();
//      msgBean.setMsgByte(byteArray);
//      baseMessage.setDataType(BeanUtil.MSG);
//      baseMessage.setData(msgBean);
//      session.write(baseMessage);
//  }
    public static void main(String[] args) {
      Client  client = new Client();
      IoConnector connector = client.creatClient();
      for(int i=0;i<20000;i++){
          IoSession session = client.getIOSession(connector);
     }
        /*for(int i=0;i<4000;i++){
            Client  client = new Client();
            IoConnector connector = client.creatClient();
            IoSession session = client.getIOSession(connector);
            String msg = Arrays.toString(new byte[1000])+":"+System.currentTimeMillis();
            msg = msg.replace(" ","");
            client.sendMsg(session, msg);
            i++;
        }*/
      /*Client  client = new Client();
      IoConnector connector = client.creatClient();
      for(int i=0;i<16000;i++){
          IoSession session = client.getIOSession(connector);
      }*/

      /*Client  client = new Client();
      IoConnector connector = client.creatClient();
      for(int i=0;i<10000;i++){
          IoSession session = client.getIOSession(connector);
      }
      IoSession session = client.getIOSession(connector);
      client.sendMsg( session,System.currentTimeMillis()+"");*/
    }
}
