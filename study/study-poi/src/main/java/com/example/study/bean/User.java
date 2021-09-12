package com.example.study.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang minzhong
 * @date 2021/9/11 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
}
