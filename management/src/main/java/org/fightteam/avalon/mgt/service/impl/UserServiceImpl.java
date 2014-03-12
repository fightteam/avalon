package org.fightteam.avalon.mgt.service.impl;

import org.fightteam.avalon.mgt.common.Routers;
import org.fightteam.avalon.mgt.service.UserService;
import org.fightteam.avalon.mgt.vo.MessageVO;
import org.fightteam.avalon.mgt.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private Routers routers;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MessageVO createUser(UserVO userVO) {
        //restTemplate.postForEntity(routers, userVO)
        return null;
    }

    @Override
    public UserVO findUser(Long id) {
        ResponseEntity<UserVO> responseEntity = restTemplate.getForEntity(routers.getUsers(), UserVO.class);
        System.out.println(responseEntity);
        return null;
    }
}
