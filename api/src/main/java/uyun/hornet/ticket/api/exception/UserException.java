package uyun.hornet.ticket.api.exception;

/**
 * 用户异常
 *
 * @author zhouww
 * @version 1.2
 * @Copyright 2011-2018 uyun
 */
public class UserException extends CommonException {

    public UserException(ExceptionCode code) {
        super(code);
    }

    public UserException(ExceptionCode code, String extMsg) {
        super(code, extMsg);
    }
}
