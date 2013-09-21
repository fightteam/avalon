package org.fightteam.avalon.rest.exception.data;

/**
 * 没有找到email异常
 *
 * 继承AuthenticationException实现
 *
 * 注意：其实不应该继承AuthenticationException这个认证异常，
 * 应该继承一个标识这个异常的父类比如自定义一个NotFoundException。
 *
 * @author excalibur
 * @since 0.0.1
 */
public class EmailNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;


    public EmailNotFoundException(String message) {
        super(message);
    }

    public EmailNotFoundException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
