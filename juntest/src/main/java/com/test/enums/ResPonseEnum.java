package com.test.enums;

/**
 * Created by AdministratorZhang on 2019/11/22 23:53
 */
public enum ResPonseEnum {
    SUCCESS("2000","执行成功"),
    FAIL("4001","执行失败");
    private String retCode;
    private String message;

    ResPonseEnum(String retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{" +
                "\"retCode\":\"" + retCode  +
                "\",\"message\":\"" + message +
                "\"}";
    }

    public static void main(String[] args) {
        System.out.println(ResPonseEnum.SUCCESS.toString());
    }
}
