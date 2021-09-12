import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.util.concurrent.Executor;

/**
 * Created by AdministratorZhang on 2017/11/15.
 */
/*public class Client {
    private ClientToMaster clientToMaster;
    private String slaveIp;
    private int slavePort;

    public Client(ClientToMaster clientToMaster) {
        this.clientToMaster = clientToMaster;
    }

    public ClientToMaster getClientToMaster() {
        return clientToMaster;
    }

    public String getSlaveIp() {
        return slaveIp;
    }

    public int getSlavePort() {
        return slavePort;
    }

    private boolean hasServer(){
        String message = clientToMaster.getSlaveInfo();
        if(message==null||message.equals("")||message.equals("error")){
            return false;
        }else {
            String[] strings = message.split(":");
            slaveIp = strings[0];
            slavePort = Integer.parseInt(strings[1]);
            return true;
        }
    }
    public NioSocketConnector getConnector(){
        if(hasServer()){
            return new NioSocketConnector();
        }
        return null;
    }
    public NioSocketConnector getConnector(int processorCount){
        if(hasServer()){
            return new NioSocketConnector(processorCount);
        }
        return null;
    }
    public NioSocketConnector getConnector(IoProcessor<NioSession> processor){
        if(hasServer()){
            return new NioSocketConnector(processor);
        }
        return null;
    }
    public NioSocketConnector getConnector(Executor executor, IoProcessor<NioSession> processor){
        if(hasServer()){
            return new NioSocketConnector(executor,processor);
        }
        return null;
    }
    public NioSocketConnector getConnector(Class<? extends IoProcessor<NioSession>> processorClass, int processorCount){
        if(hasServer()){
            return new NioSocketConnector(processorClass,processorCount);
        }
        return null;
    }
    public NioSocketConnector getConnector(Class<? extends IoProcessor<NioSession>> processorClass){
        if(hasServer()){
            return new NioSocketConnector(processorClass);
        }
        return null;
    }
}*/
