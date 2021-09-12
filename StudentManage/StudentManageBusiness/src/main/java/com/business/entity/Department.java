package com.business.entity;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-8
 * Time: 下午9:02
 * To change this template use File | Settings | File Templates.
 */
public class Department {
    private int departmentID;
    private String departmentName;
    private String departmentHead;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }
}
