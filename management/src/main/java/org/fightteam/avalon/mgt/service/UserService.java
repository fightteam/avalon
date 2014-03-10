package org.fightteam.avalon.mgt.service;

import org.fightteam.avalon.mgt.vo.MessageVO;
import org.fightteam.avalon.mgt.vo.UserVO;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserService {

    public MessageVO createUser(UserVO userVO);
}
