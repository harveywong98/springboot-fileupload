package com.example.fileupload.common.entity;

/**
 * @author edward on 2018/5/8.
 *
 * HTTP错误代码
 */
public enum ResponseCode {

    SUCCESS(200),                //成功
    FAIL(400),                   //失败
    UNAUTHORIZED(401),           //未认证（签名错误）
    NOT_FOUND(404),              //接口不存在
    INTERNAL_SERVER_ERROR(500);  //服务器内部错误

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

}
