package org.whut.mc.server.test;

import org.whut.mc.server.cluster.master.Master;
import org.whut.mc.server.core.config.PropConfig;

/**
 * Created by yangyang on 2016/5/21.
 */
public class MasterTest {
    public static void main(String[] args) {
        Master master = new Master(PropConfig.getPropConfig().getInt("master.port"));
        Thread thread = new Thread(master);
        thread.start();
    }
}
