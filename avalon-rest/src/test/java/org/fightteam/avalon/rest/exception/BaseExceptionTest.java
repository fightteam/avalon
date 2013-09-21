package org.fightteam.avalon.rest.exception;

import org.fightteam.avalon.core.entity.domain.User;
import org.junit.Test;

/**
 * 描述信息
 *
 * @author excalibur
 * @since 0.0.1
 */
public class BaseExceptionTest {

    @Test
    public void testBaseException1(){
          User user = new User();
          throw new BaseException("错误信息",user);
    }
}
