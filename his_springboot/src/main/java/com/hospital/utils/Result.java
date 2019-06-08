package com.hospital.utils;

public class Result {

    private int code;
    private String msg;
    // 这个是返回的数据，可以返回list或者java对象
    private Object data;
    public Result(){
        data = null;
        code = 0;
        msg = "";

    }
    public Result(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}