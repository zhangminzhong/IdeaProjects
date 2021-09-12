package org.bookManageSystem.business.book.web;

import org.bookManageSystem.business.book.entity.OptionType;
import org.bookManageSystem.business.book.service.OptionTypeService;
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
@Path("/optionType")
public class OptionTypeServiceWeb {
    @Autowired
    private OptionTypeService optionTypeService;

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/add")
    @POST
    public String add(@FormParam("jsonString") String jsonString){
        long appId= UserContext.currentUserAppId();
        Map<String, String> map = JsonMapper.buildNonDefaultMapper().fromJson(jsonString, HashMap.class);

        if(map.get("name")==null||map.get("name").equals("")||
                map.get("description")==null||map.get("description").equals("")
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "参数不能为空!");
        }

        OptionType optionType=new OptionType();
        optionType.setAppId(appId);
        optionType.setName(map.get("name"));
        optionType.setDescription(map.get("description"));
        optionTypeService.add(optionType);
        return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/update")
    @POST
    public String update(@FormParam("jsonString") String jsonString){
        OptionType optionType= JsonMapper.buildNonDefaultMapper().fromJson(jsonString,OptionType.class);
        if(optionType.getName()==null||optionType.getName().equals("")
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "操作名称不能为空!");
        }

        int result=optionTypeService.update(optionType);
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
        int result=optionTypeService.deleteById(id,appId);
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
        List<OptionType> list=optionTypeService.getListByAppId(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getOptionTypeById")
    @POST
    public String getReaderById(@FormParam("id")long id){
        long appId=UserContext.currentUserAppId();
        OptionType optionType=optionTypeService.getOptionTypeById(id,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(optionType,JsonResultUtils.Code.SUCCESS);
    }
}
