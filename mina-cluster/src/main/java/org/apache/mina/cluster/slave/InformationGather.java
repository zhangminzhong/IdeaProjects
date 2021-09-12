package org.apache.mina.cluster.slave;

import org.apache.mina.cluster.util.Information;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.hyperic.sigar.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by AdministratorZhang on 2017/11/20.
 */
public class InformationGather {
    private static final Logger LOGGER = LoggerFactory.getLogger(InformationGather.class);
    private Sigar sigar = new Sigar();

    /**
     * 获取Slave节点所在服务器硬件信息
     * @param acceptor
     * @return
     */
    public Information getInformation(NioSocketAcceptor acceptor){
        Information information = new Information();
        try {
            InetAddress address = acceptor.getLocalAddress().getAddress().getLocalHost();
            information.setIp(getIp());
            information.setPort(acceptor.getLocalAddress().getPort());
            getCpuInfo(information);
            getMemoryInfo(information);
            getDiskInfo(information);
            getBandWidthInfo(information);
            information.setConnectNum(acceptor.getManagedSessionCount());
        } catch (UnknownHostException e) {
            LOGGER.error("UnknownHostException:"+e.getMessage());
        }
        //LOGGER.info(information.toString());
        return information;
    }

    /**
     * 根据网卡获得IP地址
     * @return
     */
    public  String getIp(){
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = (InetAddress) addresses.nextElement();
                    if (ip != null
                            && ip instanceof Inet4Address
                            && !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                            && ip.getHostAddress().indexOf(":")==-1){
                        //System.out.println("本机的IP = " + ip.getHostAddress());
                        return ip.getHostAddress();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
        /*String ip="";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        //获得IP
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {

                                //System.out.println(ipaddress);
                                if(!"127.0.0.1".equals(ip)){
                                    ip = ipaddress;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;*/

    }

    /**
     * 获取CPU信息
     * @param information
     * @return
     */
    public Information getCpuInfo(Information information) {
        try {
            CpuInfo[] cpuInfos = sigar.getCpuInfoList();
            cpuInfos = sigar.getCpuInfoList();
            CpuPerc[] cpuPercs = sigar.getCpuPercList();
            int count = cpuInfos.length;
            information.setCpuCount(count);
            double mHz = 0;
            double cpuRatio = 0;
            for(int i=0;i<count;i++){
                mHz += cpuInfos[i].getMhz()*1.0/1000;
                cpuRatio += cpuPercs[i].getCombined();
            }
            mHz /= count;
            cpuRatio /= count;
            information.setCpuFrequency(format(mHz));
            information.setCpuRatio(format(cpuRatio));

        } catch (SigarException e) {
            LOGGER.error("SigarException:"+e.getMessage());
        }
        return information;
    }

    /**
     * 获取内存信息
     * @param information
     * @return
     */
    public Information getMemoryInfo(Information information){
        try {
            Mem mem = sigar.getMem();
            long total = mem.getTotal();
            long used = mem.getUsed();
            float ratio = (float)(used*1.0/total);
            information.setTotalMemory(format(total*1.0/1024/1024/1024));
            information.setUsedMemory(format(used*1.0/1024/1024/1024));
            information.setMemoryRatio((float)format(ratio));
        } catch (SigarException e) {
            LOGGER.error("SigarException:" + e.getMessage());
        }
        return information;
    }

    /**
     * 获取硬盘信息
     * @param information
     * @return
     */
    public Information getDiskInfo(Information information){
        try {
            FileSystem[] fileSystems = sigar.getFileSystemList();
            long totalDisk = 0;
            long usedDisk = 0;
            for(int i=0;i<fileSystems.length;i++){
                FileSystemUsage usage = sigar.getFileSystemUsage(fileSystems[i].getDirName());
                totalDisk += usage.getTotal();
                usedDisk += usage.getUsed();
            }
            float ratio = (float) (usedDisk*1.0/totalDisk);
            information.setTotalDisk(format(totalDisk*1.0/1024/1024/1024));
            information.setUsedDisk(format(usedDisk*1.0/1024/1024/1024));
            information.setDiskRatio((float) format(ratio));
        } catch (SigarException e) {
            LOGGER.error("SigarException:" + e.getMessage());
        }
        return information;
    }

    /**
     * 获取带宽信息
     * @param information
     * @return
     */
    public Information getBandWidthInfo(Information information){
        //LOGGER.info("start...");
        try {
            String[] netList = sigar.getNetInterfaceList();
            List<Long> maxSpeedList = new ArrayList<Long>();
            List<Long> rxStartList = new ArrayList<Long>();
            List<Long> txStartList = new ArrayList<Long>();
            long startTime = System.currentTimeMillis();
            for(int i=0;i<netList.length;i++){
                NetInterfaceStat statStart = sigar.getNetInterfaceStat(netList[i]);
                rxStartList.add( statStart.getRxBytes());
                txStartList.add(statStart.getTxBytes());
                maxSpeedList.add(statStart.getSpeed());
            }

            Thread.sleep(300);

            List<Long> rxEndList = new ArrayList<Long>();
            List<Long> txEndList = new ArrayList<Long>();
            long endTime = System.currentTimeMillis();
            for(int i=0;i<netList.length;i++){
                NetInterfaceStat statEnd = sigar.getNetInterfaceStat(netList[i]);
                rxEndList.add(statEnd.getRxBytes());
                txEndList.add(statEnd.getTxBytes());
            }
            float maxRatio = 0f;
            long maxSpeed = 0;
            double rtSpeed = 0;
            for(int i=0;i<netList.length;i++){
                long speed = maxSpeedList.get(i);
                if(speed>0){
                    double rxbps = (rxEndList.get(i) - rxStartList.get(i))*8/(endTime-startTime)*1000;
                    double txbps = (txEndList.get(i) - txStartList.get(i))*8/(endTime-startTime)*1000;
                    float ratio = (float) ((rxbps+txbps)/speed);
                    //LOGGER.info(String.valueOf(ratio));
                    if(maxRatio<=ratio){
                        maxRatio = ratio;
                        maxSpeed = speed;
                        rtSpeed = rxbps+txbps;
                    }
                }
            }
            information.setBandWidth(format(maxSpeed*1.0/1000/1000));
            information.setUsedBandWidth(format(rtSpeed/1000/1000));
            information.setBandWidthRatio(format(maxRatio));
            //LOGGER.info(String.valueOf("maxRatio:"+maxRatio)+"\trtSpeed:"+maxSpeed*1.0/1000/1000);
        } catch (SigarException e) {
            LOGGER.error("SigarException:" + e.getMessage());
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException:" + e.getMessage());
        }
        return information;
    }

    /**
     *小数点后保留4位有效数字
     * @param d
     * @return
     */
    public double format(double d){
        return Double.parseDouble(String.format("%.4f",d));
    }
}
