package org.apache.mina.cluster.master.algorithm;

import org.apache.mina.cluster.master.algorithm.interfaces.StaticLoadBalancer;
import org.apache.mina.cluster.util.Information;

import java.util.ArrayList;
import java.util.Map;

/**
 * 源地址哈希算法实现，静态负载均衡算法
 * Created by AdministratorZhang on 2018/2/28.
 */
public class Hash implements StaticLoadBalancer {
    @Override
    public String getServer(Map<Long, Information> map, String clientIp) {
        String server = "error";
        // 取得Ip地址List
        if(map.size()>0){
            ArrayList<Information> serverList = new ArrayList<Information>(map.values());
            int hashCode = clientIp.hashCode();
            int size = serverList.size();
            int pos = hashCode % size;
            Information info = serverList.get(pos);
            server = info.getIp()+":"+info.getPort();
        }
        return server;
    }
}
