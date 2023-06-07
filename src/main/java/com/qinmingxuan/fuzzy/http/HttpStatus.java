package com.qinmingxuan.fuzzy.http;

public enum HttpStatus {

    SUCCESS(200, "返回成功"),
    BAD_REQUEST(400, "参数错误"),
    UNAUTHORIZED(401, "鉴权失败"),
    FILE_NOT_FOUND(404, "文件不存在"),
    SERVER_ERROR(500, "服务错误"),
    SQL_ERROR(501, "SQL数据错误"),
    FILE_TIME(600, "文件过期"),
    TOKEN_MISS(700, "请求头中x-token不存在"),
    TOKEN_EXPIRED(701, "token已过期"),
    FYDM_MISS(702, "请求头中x-fydm不存在"),
    UNKNOWN_ERROR(900, "未知错误"),
    DATA_ERROR(12132, "暂无数据"),
    LOGIN_FAILURE(12015, "用户名或密码错误"),
    REFRESH_TOKEN_FAILURE(403178, "刷新token失败");

    private Integer code;
    private String msg;

    private HttpStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
