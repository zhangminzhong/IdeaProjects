package org.whut.mc.server.cluster.util;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * Created by yangyang on 2016/5/21.
 */
public class LdUtil {
    public static String getEMS() {
        StringBuffer sb=new StringBuffer();
        OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        sb.append("系统物理内存总计：" + osmb.getTotalPhysicalMemorySize()
                / 1024 / 1024 + "MB<br>");
        sb.append("系统物理可用内存总计：" + osmb.getFreePhysicalMemorySize()
                / 1024 / 1024 + "MB");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getEMS());
    }
}
