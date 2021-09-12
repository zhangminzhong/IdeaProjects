package org.apache.mina.cluster.master.algorithm;

import org.apache.mina.cluster.master.algorithm.interfaces.DynamicLoadBalancer;
import org.apache.mina.cluster.master.algorithm.interfaces.LoadBalancer;
import org.apache.mina.cluster.util.Information;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 动态负载均衡算法实现
 * Created by AdministratorZhang on 2018/2/28.
 */
public class Dynamic implements DynamicLoadBalancer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadBalancer.class);
    private float a1 = 0.1f;
    private float a2 = 0.1f;
    private float a3 = 0.4f;
    private float a4 = 0.4f;
    private float b1 = 0.05f;
    private float b2 = 0.05f;
    private float b3 = 0.3f;
    private float b4 = 0.3f;
    private float b5 = 0.3f;

    public void setA(float a1,float a2,float a3,float a4){
        if(a1+a2+a3+a4==1){
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
        }
    }

    public void setB(float b1,float b2,float b3,float b4,float b5){
        if(b1+b2+b3+b4+b5==1){
            this.b1 = b1;
            this.b2 = b2;
            this.b3 = b3;
            this.b4 = b4;
            this.b5 = b5;
        }
    }

    @Override
    public String getServer(Map<Long,Information> map,String clientIp){
        String server = "error";
        List<Information> serverList = new ArrayList<Information>(map.values());
        if(serverList.size()==0)
            return server;
        long totalConnectNum = 0;
        for(int i=0;i<serverList.size();i++){
            totalConnectNum += serverList.get(i).getConnectNum();
        }
        double maxWeight = 0;
        List<Double> minList = new ArrayList<Double>();
        for(int i=0;i<serverList.size();i++){
            Information info = serverList.get(i);
            int cpuCount = info.getCpuCount();
            double frequency = info.getCpuFrequency();
            double totalMemory = info.getTotalMemory();
            double totalDisk = info.getTotalDisk();
            double bandWidth = info.getBandWidth();
            double v = a1*cpuCount*frequency+a2*totalMemory+a3*totalDisk+a4*bandWidth;
            double lc = info.getCpuRatio();
            double lm = info.getMemoryRatio();
            double ld = info.getDiskRatio();
            double lb = info.getBandWidthRatio();
            double ln = 0;
            if(totalConnectNum!=0) {
                ln = info.getConnectNum()*1.0/totalConnectNum;
            }
            double l = b1*(1-lc)+b2*(1-lm)+b3*(1-ld)+b4*(1-lb)+b5*(1-ln);
            double w = l*v;
            minList.add(w);
            //LOGGER.info("l="+l+",v="+v+",w="+w);
            if(maxWeight<w){
                maxWeight = w;
                server = info.getIp()+":"+info.getPort();
            }
        }
        /*for(int i=0;i<minList.size();i++){
            LOGGER.info("totalSlave="+minList.size()+",the weight of "+serverList.get(i).getIp()+":"+serverList.get(i).getPort()+" is "+minList.get(i));
        }*/
        return server;
    }
}
