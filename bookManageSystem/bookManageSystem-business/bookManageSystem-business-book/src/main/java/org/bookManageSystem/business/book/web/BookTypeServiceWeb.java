package org.bookManageSystem.business.book.web;

import org.bookManageSystem.business.book.entity.BookType;
import org.bookManageSystem.business.book.service.BookTypeService;
import org.bookManageSystem.fundamental.security.UserContext;
import org.bookManageSystem.fundamental.util.json.JsonMapper;
import org.bookManageSystem.fundamental.util.json.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 14-12-29
 * Time: 下午1:04
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/bookType")
public class BookTypeServiceWeb {
    @Autowired
    private BookTypeService bookTypeService;

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/add")
    @POST
    public String add(@FormParam("name")String name,@FormParam("description")String description)throws Exception{
        if(name==null||name.trim().equals("")){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "参数不能为空");
        }
        long appId= UserContext.currentUserAppId();
        long id=0;
        try{
            id = bookTypeService.getIdByName(name,appId);
        }catch (Exception e){
            id = 0;
        }
        if(id==0){
            BookType bookType = new BookType();
            bookType.setAppId(appId);
            bookType.setName(name);
            bookType.setDescription(description);
            bookTypeService.add(bookType);
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
        }else {
            return  JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "已存在该类型!");
        }
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/delete")
    @POST
    public String delete(@FormParam("jsonString")String jsonString){
        BookType bookType= JsonMapper.buildNonDefaultMapper().fromJson(jsonString,BookType.class);
        int result=bookTypeService.delete(bookType);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS) ;
        }else {
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
        }
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/update")
    @POST
    public String update(@FormParam("jsonString")String jsonString){
        if(jsonString==null||jsonString.trim().equals("")){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"参数不能是空!");
        }
        BookType bookType = JsonMapper.buildNonDefaultMapper().fromJson(jsonString,BookType.class);
        if(bookType==null){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"参数不能是空!");
        }
        long appId= UserContext.currentUserAppId();
        bookType.setAppId(appId);
        bookTypeService.update(bookType);
        return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/list")
    @POST
    public String list(){
        long appId= UserContext.currentUserAppId();
        List<Map<String,String>> list=bookTypeService.getListByAppId(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list, JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getIdByName")
    @POST
    public String getIdByName(@FormParam("name")String name){
        long  appId=UserContext.currentUserAppId();
        long bookTypeId=bookTypeService.getIdByName(name,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(bookTypeId,JsonResultUtils.Code.SUCCESS);
    }
}
