package org.whut.mc.server.test;

import org.whut.mc.server.cluster.worker.Worker;
import org.whut.mc.server.core.config.PropConfig;

/**
 * Created by yangyang on 2016/5/21.
 */
public class WorkerTest1 {
    public static void main(String[] args) {
        Worker worker = new Worker(
                PropConfig.getPropConfig().getString("worker1.name"),
                PropConfig.getPropConfig().getString("worker1.cIP"),
                PropConfig.getPropConfig().getInt("worker1.aPort"),
                PropConfig.getPropConfig().getInt("worker1.cPort"),
                System.getProperty("user.dir") + PropConfig.getPropConfig().getString("worker.config"));
        Thread thread = new Thread(worker);
        thread.start();
    }
}
