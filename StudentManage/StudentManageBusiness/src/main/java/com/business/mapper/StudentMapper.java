package com.business.mapper;

import com.business.entity.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-7
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
public interface StudentMapper {
    public List<Student> getStudents();
    public void updateByStudent(Student student);
    public void deleteStudent(String studentID);
    public void addStudent(Student student);
    public int getTotalCount();
}
