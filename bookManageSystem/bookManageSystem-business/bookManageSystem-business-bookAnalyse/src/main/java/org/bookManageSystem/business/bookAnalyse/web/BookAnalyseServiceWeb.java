package org.bookManageSystem.business.bookAnalyse.web;

import org.bookManageSystem.business.bookAnalyse.service.BookAnalyseService;
import org.bookManageSystem.fundamental.security.UserContext;
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
 * User: yangyang
 * Date: 15-1-2
 * Time: 下午11:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/bookAnalyse")
public class BookAnalyseServiceWeb {
    @Autowired
    private BookAnalyseService bookAnalyseService;

    @Path("/getReaderBookList")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String getReaderBookList() {
        long appId = UserContext.currentUserAppId();
        long userId = UserContext.currentUserId();
        List<Map<String,String>> l = bookAnalyseService.getReaderBookByUserId(userId,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(l, JsonResultUtils.Code.SUCCESS);
    }

    @Path("/getReaderCommendsList")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String getReaderCommendsList() {
        long appId = UserContext.currentUserAppId();
        long userId = UserContext.currentUserId();
        List<Map<String,String>> list = bookAnalyseService.getReaderCommendsList(userId,appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list, JsonResultUtils.Code.SUCCESS);
    }
}
