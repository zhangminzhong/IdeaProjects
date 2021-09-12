package org.bookManageSystem.business.reader.web;

import org.bookManageSystem.business.reader.entity.Reader;
import org.bookManageSystem.business.reader.service.ReaderService;
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
 * Date: 14-12-18
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/reader")
public class ReaderServiceWeb {
    @Autowired
    private ReaderService readerService;

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/add")
    @POST
    public String add(@FormParam("jsonString") String jsonString){
        long appId= UserContext.currentUserAppId();
        Map<String, String> map = JsonMapper.buildNonDefaultMapper().fromJson(jsonString, HashMap.class);

        if(map.get("name")==null||map.get("name").equals("")||map.get("userId")==null||map.get("userId").equals("")
                ||map.get("number")==null||map.get("number").equals("")
                ||map.get("sex")==null||map.get("sex").equals("")
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "参数不能为空!");
        }
        Date createTime = new Date();

        Reader reader=new Reader();
        reader.setAppId(appId);
        reader.setUserId(Long.parseLong(map.get("userId")));
        reader.setName(map.get("name"));
        reader.setNumber(map.get("number"));
        reader.setSex(map.get("sex"));
        reader.setCreateTime(createTime);
        readerService.add(reader);
        return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/update")
    @POST
    public String update(@FormParam("jsonString") String jsonString){
        Reader reader= JsonMapper.buildNonDefaultMapper().fromJson(jsonString,Reader.class);
        if(reader.getName()==null||reader.getName().equals("")
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "姓名不能为空!");
        }

        int result=readerService.update(reader);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS) ;
        }
        else {
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
        }
    }
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/delete")
    @POST
//    public  String delete(@FormParam("jsonString") String jsonString)
    public  String delete(@FormParam("id") long id){
        long appId=UserContext.currentUserAppId();
        int result=readerService.deleteById(id,appId);
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
        List<Reader> list=readerService.getListByAppId(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getReaderById")
    @POST
    public String getReaderById(@FormParam("id")long id){
        long appId=UserContext.currentUserAppId();
        Reader reader=readerService.getReaderById(id,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(reader,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getNameById")
    @POST
    public String getNameById(@FormParam("id")long id){
        long appId=UserContext.currentUserAppId();
        String name=readerService.getNameById(id);
        return JsonResultUtils.getObjectResultByStringAsDefault(name,JsonResultUtils.Code.SUCCESS);
    }

    @Path("/getReaderByUserId")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String getReaderByUserId() {
        long appId = UserContext.currentUserAppId();
        long userId = UserContext.currentUserId();
        Map<String,String> map = readerService.getReaderByUserId(userId,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(map, JsonResultUtils.Code.SUCCESS);
    }
}
