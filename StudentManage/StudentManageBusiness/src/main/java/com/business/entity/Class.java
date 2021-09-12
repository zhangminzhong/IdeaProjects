package com.business.entity;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-8
 * Time: 下午9:09
 * To change this template use File | Settings | File Templates.
 */
public class Class {
    private int classID;
    private String className;
    private Specialty specialty;
    private Date entryDate;
    private int studentNum;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }
}
