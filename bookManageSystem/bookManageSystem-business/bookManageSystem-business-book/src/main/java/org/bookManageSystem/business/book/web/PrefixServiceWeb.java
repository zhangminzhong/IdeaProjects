package org.bookManageSystem.business.book.web;

import org.bookManageSystem.business.book.entity.Prefix;
import org.bookManageSystem.business.book.service.PrefixService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-22
 * Time: 下午2:29
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/prefix")
public class PrefixServiceWeb {
    @Autowired
    private PrefixService prefixService;

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/add")
    @POST
    public String add(@FormParam("jsonString") String jsonString){
        long appId= UserContext.currentUserAppId();
        Map<String, String> map = JsonMapper.buildNonDefaultMapper().fromJson(jsonString, HashMap.class);

        if(map.get("cip")==null||map.get("cip").equals("")||map.get("isbn")==null||map.get("isbn").equals("")
                ||map.get("author")==null||map.get("author").equals("")||map.get("pressName")==null||map.get("pressName").equals("")
                ||map.get("pressLocation")==null||map.get("pressLocation").equals("")
                ||map.get("pressTime")==null
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "参数不能为空!");
        }
        Date pressTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            pressTime = sdf.parse(map.get("pressTime"));
        }catch (Exception e){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"日期格式错误！");
        }
        Prefix prefix=new Prefix();
        prefix.setAppId(appId);
        prefix.setCip(map.get("cip"));
        prefix.setIsbn(map.get("isbn"));
        prefix.setAuthor(map.get("author"));
        prefix.setPressName(map.get("pressName"));
        prefix.setPressLocation(map.get("pressLocation"));
        prefix.setPressTime(pressTime);
        prefixService.add(prefix);
        return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/update")
    @POST
    public String update(@FormParam("jsonString") String jsonString){
        Prefix prefix= JsonMapper.buildNonDefaultMapper().fromJson(jsonString,Prefix.class);
        int result=prefixService.update(prefix);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS) ;
        }
        else {
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
        }
    }
    //    public String update(@FormParam("jsonString") String jsonString){
//        long appId= UserContext.currentUserAppId();
//        Map<String, String> map = JsonMapper.buildNonDefaultMapper().fromJson(jsonString, HashMap.class);
//
//        if(map.get("cip")==null||map.get("cip").equals("")||map.get("isbn")==null||map.get("isbn").equals("")
//                ||map.get("author")==null||map.get("author").equals("")||map.get("pressName")==null||map.get("pressName").equals("")
//                ||map.get("pressLocation")==null||map.get("pressLocation").equals("")
//                ||map.get("pressTime")==null
//                ){
//            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "参数不能为空!");
//        }
//        Date pressTime = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try{
//            pressTime = sdf.parse(map.get("pressTime"));
//        }catch (Exception e){
//            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"日期格式错误！");
//        }
//        Prefix prefix=new Prefix();
//        prefix.setAppId(appId);
//        prefix.setId(Long.parseLong(map.get("ip")));
//        prefix.setCip(Long.parseLong(map.get("cip")));
//        prefix.setIsbn(map.get("isbn"));
//        prefix.setAuthor(map.get("author"));
//        prefix.setPressName(map.get("pressName"));
//        prefix.setPressLocation(map.get("pressLocation"));
//        prefix.setPressTime(pressTime);
//        int result=prefixService.update(prefix);
//        if(result>0){
//            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS) ;
//        }
//        else {
//            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
//        }
//    }
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/delete")
    @POST
//    public  String delete(@FormParam("jsonString") String jsonString)
    public  String delete(@FormParam("id") long id){
        long appId=UserContext.currentUserAppId();
        int result=prefixService.deleteById(id,appId);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
        }
        else {
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
        }
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/list")
    @POST
    public String list(){
        long appId=UserContext.currentUserAppId();
        List<Prefix> list=prefixService.getListByAppId(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getReaderById")
    @POST
    public String getReaderById(@FormParam("id")long id){
        long appId=UserContext.currentUserAppId();
        Prefix prefix=prefixService.getPrefixById(id, appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(prefix,JsonResultUtils.Code.SUCCESS);
    }
}
