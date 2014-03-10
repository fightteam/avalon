package org.fightteam.avalon.mgt.service.impl;

import org.fightteam.avalon.mgt.service.UserService;
import org.fightteam.avalon.mgt.vo.MessageVO;
import org.fightteam.avalon.mgt.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MessageVO createUser(UserVO userVO) {

        return null;
    }
}
