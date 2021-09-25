package com.example.study.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhang minzhong
 * @date 2021/9/12 12:29
 */

@Data
@ToString
@Configuration
@RefreshScope
//@Component
//@ConfigurationProperties(prefix = "user")
public class UserConfig {
    @Value("${user.userName}")
    public String userName;

    @Value("${user.password}")
    public String password;
}
