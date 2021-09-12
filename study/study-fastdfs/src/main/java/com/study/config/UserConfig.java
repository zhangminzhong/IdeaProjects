package com.study.config;

import lombok.Data;
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
@Component
@ConfigurationProperties(prefix = "user")
public class UserConfig {
//    @Value("${username}")
    public String userName;

//    @Value("${password}")
    public String password;
}
