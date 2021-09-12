package com.itheima;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.WatchPathable;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuratorTest {

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
     * 创建节点，create持久 临时 顺序 数据
     * 1.基本创建
     * 2.创建节点 带有数据
     * 3.设置节点的类型
     * 4.创建多级节点 /app/app1
     */
    @Test
    public void testCreate() throws Exception {
        //1.基本创建
        //如果创建节点没有数据，当前客户端的ip默认作为数据存储
//        String s1 = client.create().forPath("/app1");
//        System.out.println(s1);
        //2.创建节点 带有数据
//        String s2 = client.create().forPath("/app2","hehe".getBytes());
//        System.out.println(s2);
        //3.设置节点的类型
        //默认持久化的
//        String s3 = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app3","hehe".getBytes());
//        System.out.println(s3);
        //4.创建多级节点 /app/app1
        //creatingParentContainersIfNeeded()如果父节点不存在，创建父节点
        String s4 = client.create().creatingParentContainersIfNeeded().forPath("/app4/p1","hehe".getBytes());
        System.out.println(s4);
    }

    /**
     * 查询
     * 1.查询数据 get
     * 2.查询子节点 ls
     * 3.查询节点状态信息 ls -s
     */
    @Test
    public void testGet() throws Exception {
        //1.查询数据
        byte[] app1Byte = client.getData().forPath("/app1");
        System.out.println(new String(app1Byte));
        //2.查询子节点
        List<String> pathList = client.getChildren().forPath("/");
        System.out.println(pathList);
        //3.查询节点状态信息
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        System.out.println(stat);
    }

    /**
     * 修改
     */
    @Test
    public void testSet() throws Exception {
        //1.修改数据
        client.setData().forPath("/app1","itcast".getBytes());
        System.out.println(new String(client.getData().forPath("/app1")));
        //2.根据版本修改
        //version是通过查询出来的，保持原子性操作
        int version = 0;
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        version = stat.getVersion();
        System.out.println(version);
        client.setData().withVersion(version).forPath("/app1","haha".getBytes());
    }

    /**
     * 删除节点
     */
    @Test
    public void testDelete() throws Exception {
        //delete deleteall
        //1.删除单个节点
//        client.delete().forPath("/app1");
        //2.删除带有子节点的节点
//        client.delete().deletingChildrenIfNeeded().forPath("/app4");
        //3.必须成功的删除，防止网络抖动，本质就是重试
//        client.create().forPath("/app2");
//        client.delete().guaranteed().forPath("/app2");
        //4.回调
        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("删除了");
                System.out.println(event);
            }
        }).forPath("/app1");
    }
}
