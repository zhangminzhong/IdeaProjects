package org.whut.mc.server.cluster.util;

import org.whut.mc.server.core.communication.Request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yangyang on 2016/5/21.
 */
public class Info implements Serializable {
    private String name;
    private String IP;
    private int port;
    private int ld;
    private boolean status;
    private Date date;
    private List<Request> requests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getLd() {
        return ld;
    }

    public void setLd(int ld) {
        this.ld = ld;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
