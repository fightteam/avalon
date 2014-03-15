package org.fightteam.avalon.mgt.service.impl;

import org.fightteam.avalon.mgt.bo.UserBO;
import org.fightteam.avalon.mgt.common.Routers;
import org.fightteam.avalon.mgt.service.UserService;
import org.fightteam.avalon.mgt.vo.MessageVO;
import org.fightteam.avalon.mgt.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
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
    private Routers routers;

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public MessageVO createUser(UserBO userBO) {
        //restTemplate.postForEntity(routers, userVO)
        return null;
    }

    @Override
    public UserBO findUser(Long id) {

//        UserBO userBO = restTemplate.getForObject(routers.getUsers(), UserBO.class);

        Map<String, String> vars = new HashMap<>();
        vars.put("id", id.toString());
        Resource<UserBO> userBOResource = null;

        ResponseEntity<UserBO> resourceResponseEntity = restTemplate.getForEntity(routers.getUsers(), UserBO.class, vars);
        System.out.println(resourceResponseEntity);
        System.out.println(resourceResponseEntity.getBody().getUserLinks().getSelf());
        return null;
    }

}
