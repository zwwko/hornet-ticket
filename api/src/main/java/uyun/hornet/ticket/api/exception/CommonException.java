package uyun.hornet.ticket.api.exception;

/**
 * 通用异常类
 *
 * @author zhouww
 * @version 1.2
 * @Copyright 2011-2018 uyun
 */
public class CommonException extends RuntimeException {
    private int errorCode = 0;

    public CommonException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public CommonException(ExceptionCode exceptionConst) {
        super(exceptionConst.getMsg());
        this.errorCode = exceptionConst.getErrorCode();
    }

    public CommonException(ExceptionCode exceptionConst, String extMsg) {
        super(exceptionConst.getMsg() + ":" + extMsg);
        this.errorCode = exceptionConst.getErrorCode();
    }

    public CommonException(int errorCode, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
    }

    public CommonException() {
    }

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public Throwable getException() {
        return super.getCause();
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
