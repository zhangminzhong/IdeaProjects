package org.apache.mina.cluster.util;

import java.io.Serializable;

/**
 * 保存服务器信息的类
 * Created by AdministratorZhang on 2017/11/2.
 */
public class Information implements Serializable{
    private String ip;//slave节点ip地址
    private int port;//slave节点监听客户端的端口号
    private int cpuCount;//cpu核心数
    private double cpuFrequency;//cpu主频
    private double cpuRatio;//cpu使用率
    private double totalMemory;//内存大小
    private double usedMemory;//已用内存
    private float memoryRatio;//内存使用率
    private double totalDisk;//磁盘大小
    private double usedDisk;//已用磁盘
    private float diskRatio;//磁盘使用率
    private double bandWidth;//带宽
    private double usedBandWidth;//已用带宽
    private double bandWidthRatio;//带宽使用率
    private int connectNum;//连接数

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(int cpuCount) {
        this.cpuCount = cpuCount;
    }

    public double getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(double cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    public double getCpuRatio() {
        return cpuRatio;
    }

    public void setCpuRatio(double cpuRatio) {
        this.cpuRatio = cpuRatio;
    }

    public double getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(double totalMemory) {
        this.totalMemory = totalMemory;
    }

    public double getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(double usedMemory) {
        this.usedMemory = usedMemory;
    }

    public float getMemoryRatio() {
        return memoryRatio;
    }

    public void setMemoryRatio(float memoryRatio) {
        this.memoryRatio = memoryRatio;
    }

    public double getTotalDisk() {
        return totalDisk;
    }

    public void setTotalDisk(double totalDisk) {
        this.totalDisk = totalDisk;
    }

    public double getUsedDisk() {
        return usedDisk;
    }

    public void setUsedDisk(double usedDisk) {
        this.usedDisk = usedDisk;
    }

    public void setUsedDisk(long usedDisk) {
        this.usedDisk = usedDisk;
    }

    public float getDiskRatio() {
        return diskRatio;
    }

    public void setDiskRatio(float diskRatio) {
        this.diskRatio = diskRatio;
    }

    public double getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(double bandWidth) {
        this.bandWidth = bandWidth;
    }

    public double getUsedBandWidth() {
        return usedBandWidth;
    }

    public void setUsedBandWidth(double usedBandWidth) {
        this.usedBandWidth = usedBandWidth;
    }

    public double getBandWidthRatio() {
        return bandWidthRatio;
    }

    public void setBandWidthRatio(double bandWidthRatio) {
        this.bandWidthRatio = bandWidthRatio;
    }

    public int getConnectNum() {
        return connectNum;
    }

    public void setConnectNum(int connectNum) {
        this.connectNum = connectNum;
    }

    @Override
    public String toString() {
      /*  return "Information{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", cpuCount=" + cpuCount +
                ", cpuFrequency=" + cpuFrequency +
                ", cpuRatio=" + cpuRatio +
                ", totalMemory=" + totalMemory +
                ", usedMemory=" + usedMemory +
                ", memoryRatio=" + memoryRatio +
                ", totalDisk=" + totalDisk +
                ", usedDisk=" + usedDisk +
                ", diskRatio=" + diskRatio +
                ", bandWidth=" + bandWidth +
                ", usedBandWidth=" + usedBandWidth +
                ", bandWidthRatio=" + bandWidthRatio +
                ", connectNum=" + connectNum +
                '}';*/
        return "Information{" +
                "cpuRatio=" + cpuRatio +
                ",memoryRatio=" + memoryRatio +
                ",diskRatio=" + diskRatio +
                ",bandWidthRatio=" + bandWidthRatio +
                ",connectNum=" + connectNum +
                '}';
        /*return "Information";*/
        /*return "Information{ip="+ip+",port="+port+",connectNum="+connectNum+"}";*/
    }

}
