package com.itheima;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuratorWatcherTest {

    private CuratorFramework client;

    /**
     *  建立连接
     */
    @Before
    public void testConnect(){
        //第一种方式
        /**
         * Create a new client
         *
         * @param connectString       连接字符串，zk地址:端口 192.168.0.106:2181
         * @param sessionTimeoutMs    会话超时时间，单位ms
         * @param connectionTimeoutMs 连接超时时间，单位ms
         * @param retryPolicy         重试策略
         * @return client
         */
//        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.0.106:2181",
//                60*1000,15*1000,
//                new ExponentialBackoffRetry(3*1000,10));
//        client.start();
        //第二种方式
        client = CuratorFrameworkFactory.builder().connectString("192.168.0.106:2181")
                .sessionTimeoutMs(60*1000).connectionTimeoutMs(15*1000)
                .retryPolicy(new ExponentialBackoffRetry(3*1000,10))
                .namespace("itheima")//名称空间，所有操作都会认为这个是根目录
                .build();
        client.start();
    }
    @After
    public void close(){
        if (client != null){
            client.close();
        }
    }

    /**
     * 演示NodeCache
     * @throws Exception
     */
    @Test
    public void testNodeCache() throws Exception {
        //
        //1.创建NodeCache对象
        NodeCache nodeCache = new NodeCache(client,"/app1");
        //2.注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了");
                //获取节点后的数据
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        //3.开启监听，如果设置为true，则开启监听时，加载缓存数据
        nodeCache.start(true);
        while(true){
            Thread.sleep(1000);
        }
    }

    /**
     * 演示PathChildrenCache：监听某个节点的子节点
     * @throws Exception
     */
    @Test
    public void testPathChildrenCache() throws Exception {
        //1.创建监听对象
        PathChildrenCache childrenCache = new PathChildrenCache(client,"/app2",true);
        //2.绑定监听器
        childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("子节点变化了");
                System.out.println(event);
                //监听子节点数据变更，并拿到变更后的数据
                PathChildrenCacheEvent.Type type = event.getType();
                //判断是否为update
                if(PathChildrenCacheEvent.Type.CHILD_UPDATED.equals(type)){
                    byte[] data = event.getData().getData();
                    System.out.println(new String(data));
                }
            }
        });
        //3.开启监听
        childrenCache.start();
        while(true){
            Thread.sleep(1000);
        }
    }
}
