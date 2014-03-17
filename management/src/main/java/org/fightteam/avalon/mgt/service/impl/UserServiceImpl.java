package org.fightteam.avalon.mgt.service.impl;

import org.fightteam.avalon.mgt.service.bo.UserBO;
import org.fightteam.avalon.mgt.rest.common.RestRouters;
import org.fightteam.avalon.mgt.service.UserService;
import org.fightteam.avalon.mgt.web.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private RestRouters restRouters;

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public MessageVO createUser(UserBO userBO) {
        //restTemplate.postForEntity(routers, userVO)
        return null;
    }

    @Override
    public UserBO findUser(Long id) {
        Map<String, String> vars = new HashMap<>();
        vars.put("id", id.toString());

        ResponseEntity<UserBO> resourceResponseEntity = restTemplate.getForEntity(restRouters.getUsers(), UserBO.class, vars);

        if (resourceResponseEntity.getStatusCode() != HttpStatus.OK){

        }
        return resourceResponseEntity.getBody();
    }

}
