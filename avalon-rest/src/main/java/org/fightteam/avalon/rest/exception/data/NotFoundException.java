package org.fightteam.avalon.rest.exception.data;

import org.fightteam.avalon.rest.exception.BaseException;

/**
 * 数据层 查找数据失败 异常
 *
 * 自定义类型方便标识，异常来源
 *
 * @author excalibur
 * @since 0.0.1
 */
public class NotFoundException extends BaseException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Object errorCode) {
        super(message, errorCode);
    }


}
