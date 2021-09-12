package org.apache.mina.cluster.master.algorithm;

import org.apache.mina.cluster.master.algorithm.interfaces.StaticLoadBalancer;
import org.apache.mina.cluster.util.Information;

import java.util.ArrayList;
import java.util.Map;

/**
 * 轮询算法实现，静态负载均衡算法
 * Created by AdministratorZhang on 2018/2/28.
 */
public class RoundRobin implements StaticLoadBalancer {
    private static Integer pos = 0;
    @Override
    public String getServer(Map<Long, Information> map, String clientIp) {
        String server = "error";
        // 取得Ip地址List
        ArrayList<Information> serverList = new ArrayList<Information>(map.values());
        if(serverList.size()>0){
            synchronized (pos)
            {
                if (pos >= serverList.size())
                    pos = 0;
                Information info = serverList.get(pos);
                server = info.getIp()+":"+info.getPort();
                pos ++;
            }
        }
        return server;
    }
}
