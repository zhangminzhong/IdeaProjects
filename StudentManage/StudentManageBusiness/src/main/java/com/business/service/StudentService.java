package com.business.service;

import com.business.entity.Student;
import com.business.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-7
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */
@Component
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    public List<Student> getStudents(){
        List<Student> students = studentMapper.getStudents();
        //System.out.println(students.get(0).getAddress());
        return students;
    }

    public void updateByStudent(Student student){
        studentMapper.updateByStudent(student);
    }

    public void deleteStudent(String studentID){
        studentMapper.deleteStudent(studentID);
    }
    public void addStudent(Student student){
        studentMapper.addStudent(student);
    }
    public int getTotalCount(){
        return studentMapper.getTotalCount();
    }
}
