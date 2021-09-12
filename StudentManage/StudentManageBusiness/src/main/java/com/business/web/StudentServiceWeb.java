package com.business.web;

import com.business.entity.Student;
import com.business.entity.User;
import com.business.service.StudentService;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-7
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/student")
public class StudentServiceWeb {
    @Autowired
    StudentService studentService;
    @Context
    HttpServletRequest request;

    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getList")
    public String getStudents(){
        //System.out.println(request.getSession().getAttribute("user"));
        /*if((User)request.getSession().getAttribute("user")==null){
            return null;
        }*/
        List<Student> students = studentService.getStudents();
        ObjectMapper objectMapper = new ObjectMapper();
        //JsonGenerator jsonGenerator;
        String studentListStrings="";
        try{
            //jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            //jsonGenerator.writeObject(students);
            System.out.println();
            studentListStrings = objectMapper.writeValueAsString(students);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return studentListStrings;
    }
    @POST
    //@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/updateStudent")
    public String updateStudent(@FormParam("studentID") String studentID,@FormParam("studentName") String studentName,@FormParam("telephone") String telephone,@FormParam("address") String address){
        Student student = new Student();
        student.setStudentID(studentID);
        student.setStudentName(studentName);
        student.setTelephone(telephone);
        student.setAddress(address);
        System.out.println(student.getStudentName());
        try{
            studentService.updateByStudent(student);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
    @POST
    @Path("/deleteStudent")
    public String deleteStudent(@FormParam("studentID") String studenID){
        try{
            studentService.deleteStudent(studenID);
        }  catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

   // @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    @Path("/addStudent")
    public String addStudent(@FormParam("jsonString") String jsonString){
        /*@FormParam("studentName") String studentName,@FormParam("nation") String nation,
                             @FormParam("sex") String sex,@FormParam("birthday") String birthdayStr,
                             @FormParam("classID") int classID,@FormParam("telephone") String telephone,
                             @FormParam("address") String address,@FormParam("remark") String remark*/
        System.out.println(jsonString);
        Student student = new Student();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            student = objectMapper.readValue(jsonString,Student.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(student.getStudentID()+":"+student.getStudentName()+":"+
                student.getNation()+":"+student.getSex()+":"+student.getBirthday()
                +":"+student.getClassID()+":"+student.getTelephone()+":"+student.getAddress()
                +":"+student.getRemark()+":"+student.getCreditHour()+":"+student.getEntryDate());

        student.setCreditHour(0);

        java.util.Date tempDate = new java.util.Date();
        System.out.println(tempDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString =sdf.format(tempDate);
        System.out.println(dateString);
        java.sql.Date entryDate = java.sql.Date.valueOf(dateString);
        System.out.println(entryDate);
        student.setEntryDate(entryDate);

        String s = "123456789";
        int begin=1001;
        int count = 0;
        count = studentService.getTotalCount();
        s+=(begin+count);
        System.out.println(s);
        student.setStudentID(s);

        System.out.println(student.getStudentID()+":"+student.getStudentName()+":"+
                student.getNation()+":"+student.getSex()+":"+student.getBirthday()
                +":"+student.getClassID()+":"+student.getTelephone()+":"+student.getAddress()
                +":"+student.getRemark()+":"+student.getCreditHour()+":"+student.getEntryDate());


        try{
            studentService.addStudent(student);
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

}
