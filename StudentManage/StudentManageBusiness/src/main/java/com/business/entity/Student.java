package com.business.entity;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-7
 * Time: 下午7:45
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private String studentID;
    private String studentName;
    private String nation;
    private char sex;
    private Date birthday;
    private int classID;
    private String telephone;
    private float creditHour;
    private Date entryDate;
    private String address;
    private String remark;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public float getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(float creditHour) {
        this.creditHour = creditHour;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return this.getStudentName();
    }
}
