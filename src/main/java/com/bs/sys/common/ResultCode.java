package com.bs.sys.common;

/**
 * @author Hu Min
 * 2019/3/27 14:42
 */
public enum  ResultCode {
    SUCCESS(200,"success"),
    unkown_error(10001,"未知异常"),
    db_opterror(10002,"数据库操作异常"),
    user_notexist(10003,"用户不存在"),
    user_exist_error(10004,"用户已存在");



    private ResultCode(int code,String message){
        this.code=code;
        this.message=message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
