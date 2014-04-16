package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.data.models.Consumer;
import org.fightteam.avalon.security.service.UserService;
import org.fightteam.avalon.web.common.Routers;
import org.fightteam.avalon.web.controller.form.UserFormBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册
 *
 * @author faith
 * @since 0.0.1
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = Routers.register,method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> register(HttpServletRequest request, @ModelAttribute UserFormBean userFormBean){
        System.out.println("1111111111111");
        System.out.println(userFormBean);
        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(userFormBean, consumer);
        consumer.setIp(getIp(request));
        userService.registerUser(consumer);

        Map<String, Object> map = new HashMap<>();
        map.put("status", HttpStatus.CREATED.value());
        map.put("message", "成功注册！");
        return map;
    }

    // 获取请求端实际IP
    private String getIp(HttpServletRequest request){

        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
