package com.hospital.utils;

public enum ResultCode {

    SUCCESS(200,"请求成功"),
    ERROR(-1,"网络异常，请求失败");

    private int code;
    private String mes;

    ResultCode(int code,String mes){
        this.code = code;
        this.mes = mes;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return mes;
    }
}
