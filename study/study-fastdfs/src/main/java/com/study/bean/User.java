package com.study.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang minzhong
 * @date 2021/9/11 22:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
}
