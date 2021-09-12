package org.bookManageSystem.business.anonymous.web;

import org.bookManageSystem.business.anonymous.service.AnonymousService;
import org.bookManageSystem.fundamental.logger.FundamentalLogger;
import org.bookManageSystem.fundamental.security.UserContext;
import org.bookManageSystem.fundamental.util.json.JsonResultUtils;
import org.bookManageSystem.fundamental.util.validate.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * AnonymousUser: yangyang
 * Date: 14-11-1
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/anonymous")
public class AnonymousServiceWeb {
    private static final FundamentalLogger logger = FundamentalLogger.getLogger(AnonymousServiceWeb.class);

    @Autowired
    private AnonymousService anonymousService;

    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String test() {
        System.out.println("Hello World !");
        return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.SUCCESS.getCode(), "匿名访问成功!");
    }

    @Path("/validateImage")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String validateImage(@Context HttpServletRequest request) throws IOException {
        Map<String,BufferedImage> map = ImageUtil.createImage();
        String key = map.keySet().iterator().next();
        BufferedImage image = map.get(key);
        String imagePath = ImageUtil.getInputFilePath(image, key, request);
        return JsonResultUtils.getObjectResultByStringAsDefault(imagePath, JsonResultUtils.Code.SUCCESS);
    }

    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String register(@FormParam("user")String jsonString) {
        logger.info("待注册用户：" + jsonString);
        return JsonResultUtils.getObjectResultByStringAsDefault(jsonString, JsonResultUtils.Code.SUCCESS);
    }

    @Path("/commends")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String anonymousCommend(@FormParam("bookTypeId") Long bookTypeId) {
//        long appId = UserContext.currentUserAppId();
        long appId = 1;
        List<Map<String,String>> result = anonymousService.commendBook(bookTypeId, appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(result, JsonResultUtils.Code.SUCCESS);
    }

    @Path("/bestBookType")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @POST
    public String getBestBookTypes() {
        long appId = 1;
        List<Map<String,Object>> bookTypes = anonymousService.getBestBookTypes(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(bookTypes, JsonResultUtils.Code.SUCCESS);
    }
}
