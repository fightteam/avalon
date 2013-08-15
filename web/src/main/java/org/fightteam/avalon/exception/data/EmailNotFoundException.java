package org.fightteam.avalon.exception.data;

import org.springframework.security.core.AuthenticationException;

/**
 * 没有找到email异常
 * User: faith
 * Date: 13-8-1
 * Time: 上午11:08
 * 继承AuthenticationException实现
 */
public class EmailNotFoundException extends AuthenticationException {

    public EmailNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public EmailNotFoundException(String msg) {
        super(msg);
    }

}
