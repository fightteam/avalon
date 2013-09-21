package org.fightteam.avalon.rest.exception;

/**
 * 基础异常
 *
 * 所有自定义异常都应该继承该类
 *
 * @author excalibur
 * @since 0.0.1
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    // 标识产生异常的类
    protected Object errorCode;

    public BaseException(String message) {
        super(message);
    }


    public BaseException(String message, Object errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public Object getErrorCode() {
        return errorCode;
    }
}
