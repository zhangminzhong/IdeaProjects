package org.whut.mc.server.test;

import org.whut.mc.server.cluster.worker.Worker;
import org.whut.mc.server.core.config.PropConfig;

/**
 * Created by yangyang on 2016/5/21.
 */
public class WorkerTest2 {
    public static void main(String[] args) {
        Worker worker = new Worker(
                PropConfig.getPropConfig().getString("worker2.name"),
                PropConfig.getPropConfig().getString("worker2.cIP"),
                PropConfig.getPropConfig().getInt("worker2.aPort"),
                PropConfig.getPropConfig().getInt("worker2.cPort"),
                System.getProperty("user.dir") + PropConfig.getPropConfig().getString("worker.config"));
        Thread thread = new Thread(worker);
        thread.start();
    }
}
