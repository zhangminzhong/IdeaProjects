package com.gupaoedu.example.springcloudalibabanacos.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "User对象",description = "用于接收用户信息")
public class User {
    @ApiModelProperty(value = "姓名",example = "张三")
    private String userName;
    @ApiModelProperty(value = "密码",example = "123456")
    private String password;
}
