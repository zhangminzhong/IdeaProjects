

import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * 网卡信息、接口数据、流量
 *
 * 使用Sigar获得网卡信息
 *
 */
public class NetInterfaceData {

    private NetInterfaceConfig config;
    private NetInterfaceStat stat;
    private double rxbps;
    private double txbps;

    public NetInterfaceData() {}

    public void populate(Sigar sigar, String name)
            throws SigarException {

        config = sigar.getNetInterfaceConfig(name);

        try {

            long start = System.currentTimeMillis();
            NetInterfaceStat statStart = sigar.getNetInterfaceStat(name);
            long rxBytesStart = statStart.getRxBytes();
            long txBytesStart = statStart.getTxBytes();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            NetInterfaceStat statEnd = sigar.getNetInterfaceStat(name);
            long rxBytesEnd = statEnd.getRxBytes();
            long txBytesEnd = statEnd.getTxBytes();

            rxbps = (rxBytesEnd - rxBytesStart)*8/(end-start)*1000;
            txbps = (txBytesEnd - txBytesStart)*8/(end-start)*1000;

            stat = sigar.getNetInterfaceStat(name);
            if(stat.getSpeed()!=0){
                System.out.print("带宽使用率："+(rxbps+txbps)/stat.getSpeed()+"，");
            }
            System.out.println("接收速度："+(rxbps)+"bps，发送速度："+(txbps)+"bps，"+stat);
        } catch (SigarException e) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static NetInterfaceData gather(Sigar sigar, String name)
            throws SigarException {

        NetInterfaceData data = new NetInterfaceData();
        data.populate(sigar, name);
        return data;
    }

    public NetInterfaceConfig getConfig() {
        return config;
    }

    public NetInterfaceStat getStat() {
        return stat;
    }



    public double getRxbps() {
        return rxbps;
    }

    public double getTxbps() {
        return txbps;
    }

    public static void main(String[] args) throws Exception {
        Sigar sigar = new Sigar();
        String[] netIfs = sigar.getNetInterfaceList();
        List netIfList = new ArrayList();
        for ( String name:netIfs ) {
            NetInterfaceConfig netInterfaceConfig = sigar.getNetInterfaceConfig(name);
            System.out.print("Address = " + netInterfaceConfig.getAddress() + "，");// IP地址
            NetInterfaceData netIfData1 = NetInterfaceData.gather(sigar, name);
            netIfList.add(netIfData1);
        }
        /*XStream xstream = new XStream();
        xstream.alias("NetInterfaceDatas", List.class);
        xstream.alias("NetInterfaceData", NetInterfaceData.class);
        System.out.println(xstream.toXML(netIfList));*/
    }
}
