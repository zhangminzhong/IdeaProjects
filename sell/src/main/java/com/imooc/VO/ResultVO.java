package com.imooc.VO;

import lombok.Data;

/**
 * Created by AdministratorZhang on 2019/11/3 12:11
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;
}
