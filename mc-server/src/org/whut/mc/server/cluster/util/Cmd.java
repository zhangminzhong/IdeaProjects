package org.whut.mc.server.cluster.util;

/**
 * Created by yangyang on 2016/5/14.
 */
public class Cmd extends Thread {
    public static final String MASTER_START = "master start";
    public static final String MASTER_STOP = "master stop";
    public static final String WORKER_START = "worker start";
    public static final String WORKER_STOP = "worker stop";
    public static final String WORKER_SEND = "worker send";
    public static final String WORKER_TIMER_START = "worker timer start";
    public static final String WORKER_TIMER_STOP = "worker timer stop";
    public static final String MASTER_TIMER_START = "master timer start";
    public static final String MASTER_TIMER_STOP = "master timer stop";
    public static final String BEST_NODE = "best node";
    public static final String EXIT = "exit";
}
