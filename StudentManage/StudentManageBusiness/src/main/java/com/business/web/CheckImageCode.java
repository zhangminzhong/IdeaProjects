package com.business.web;

import com.business.util.ImageUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-5-5
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/imageCode")
public class CheckImageCode {
    @Path("/validateImage")
    @POST
    public String validateImage(@Context HttpServletRequest request) throws IOException {
        Map<String,BufferedImage> map = ImageUtil.createImage();
        String key = map.keySet().iterator().next();
        BufferedImage image = map.get(key);
        String imagePath = ImageUtil.getInputFilePath(image, key, request);
        return key;
    }
}
