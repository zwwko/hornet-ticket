package uyun.hornet.ticket.api.exception;

/**
 * 异常编码
 *
 * @author zhouww
 * @version 1.2
 * @Copyright 2011-2018 uyun
 */
public enum ExceptionCode {
    USER_NOT_EXISTS(1000, "用户不存在"),
    USER_FORBIDDEN(1001, "用户被禁用");

    private int errorCode;
    private String msg;

    ExceptionCode(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public static ExceptionCode getByCode(int code) {
        ExceptionCode[] values = values();
        for (ExceptionCode exceptionConst : values) {
            if (exceptionConst.getErrorCode() == code) {
                return exceptionConst;
            }
        }
        return null;
    }

    public String toString() {
        return "code=" + this.errorCode + ", msg=" + this.msg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }
}
