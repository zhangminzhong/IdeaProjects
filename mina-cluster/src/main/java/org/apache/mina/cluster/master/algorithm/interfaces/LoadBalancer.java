package org.apache.mina.cluster.master.algorithm.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.mina.cluster.util.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 负载均衡算法接口
 * Created by AdministratorZhang on 2017/11/16.
 */
public interface LoadBalancer {
    /**
     * 计算最优服务器信息
     * @param map 所有Slave节点信息
     * @param clientIp 当前请求的客户端Ip地址
     * @return 返回"IP:PORT"
     */
    public String getServer(Map<Long,Information> map,String clientIp);
}
