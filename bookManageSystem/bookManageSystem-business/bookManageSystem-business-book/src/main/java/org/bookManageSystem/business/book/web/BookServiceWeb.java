package org.bookManageSystem.business.book.web;

import org.bookManageSystem.business.book.entity.Book;
import org.bookManageSystem.business.book.service.BookService;
import org.bookManageSystem.business.book.service.BookTypeService;
import org.bookManageSystem.fundamental.security.UserContext;
import org.bookManageSystem.fundamental.util.json.JsonMapper;
import org.bookManageSystem.fundamental.util.json.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 14-12-29
 * Time: 下午12:55
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/book")
public class BookServiceWeb {
    @Autowired
    private BookService bookService;

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/add")
    @POST
    public String add(@FormParam("jsonString")String jsonString){
        if(jsonString==null||jsonString.trim().equals("")){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"参数不能为空");
        }
        Book book = JsonMapper.buildNonDefaultMapper().fromJson(jsonString,Book.class);
        long appId= UserContext.currentUserAppId();
        Long id;
        try{
            id=bookService.getIdByNumber(book.getNumber(),appId);
        }catch(Exception e){
            id=null;
        }
        if(id==null){
            book.setAppId(appId);
            bookService.add(book);
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.SUCCESS.getCode(), "添加成功!");
        }else{
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "设备编号已存在!");
        }
//    public String add(@FormParam("name")String name,@FormParam("number")String number,@FormParam("bookTypeId")String bookTypeId,@FormParam("prefixId")String prefixId,@FormParam("rentNumber")String rentNumber)
//    throws ParseException{
//        if(name==null||name.equals("")){
//            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"参数不能是空!");
//        }
//        long appId= UserContext.currentUserAppId();
//        long id;
//        try{
//            id = bookService.getIdByNumber(number,appId);
//        }catch (Exception e){
//            id = 0;
//        }
//        if(id == 0){
//            Book book = new Book();
//            book.setAppId(appId);
//            book.setName(name);
//            book.setNumber(number);
//            try{
//                book.setCount(Long.parseLong(rentNumber));
//            }catch (Exception e){
//                book.setCount(null);
//            }
//            try{
//                book.setBookTypeId(Long.parseLong(bookTypeId));
//            }catch (Exception e){
//                book.setBookTypeId(null);
//            }
//            try{
//                book.setPrefixId(Long.parseLong(prefixId));
//            }catch (Exception e){
//                book.setPrefixId(null);
//            }
//            bookService.add(book);
//            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
//        }else {
//            return  JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "已存在该类型!");
//        }
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/delete")
    @POST
    public String delete(@FormParam("jsonString")String jsonString){
        Book book = JsonMapper.buildNonDefaultMapper().fromJson(jsonString,Book.class);
        int result=bookService.delete(book);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS) ;
        }
        else {
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
        Book book = JsonMapper.buildNonDefaultMapper().fromJson(jsonString,Book.class);
        if(book==null){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"参数不能是空!");
        }
        long appId= UserContext.currentUserAppId();
        book.setAppId(appId);
        bookService.update(book);
        return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/list")
    @POST
    public String list(){
        long appId= UserContext.currentUserAppId();
        List<Map<String,String>> list=bookService.getListByAppId(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list, JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getIdByNumber")
    @POST
    public String getIdByNumber(@FormParam("number")String number){
        long appId= UserContext.currentUserAppId();
        long bookId=bookService.getIdByNumber(number,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(bookId, JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    @Path("/findImageAndDescription")
    public String findImageAndDescription(@FormParam("number")String number) {
        long appId = UserContext.currentUserAppId();
        Map<String,String> map = bookService.findImageAndDescription(number,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(map, JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/search")
    @POST
    public String search(@FormParam("searchContent")String searchContent,@FormParam("typeVal")String typeVal){

        List<Map<String,String>> list= bookService.search(searchContent,typeVal);
        return JsonResultUtils.getObjectResultByStringAsDefault(list, JsonResultUtils.Code.SUCCESS);
    }
}
