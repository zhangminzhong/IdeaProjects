package com.imooc.enums;

import lombok.Getter;

/**
 * Created by AdministratorZhang on 2019/11/3 11:11
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
