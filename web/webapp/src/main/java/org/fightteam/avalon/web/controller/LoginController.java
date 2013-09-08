package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.web.config.Router;
import org.fightteam.avalon.web.config.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录控制
 * User: faith
 * Date: 13-8-2
 * Time: 上午9:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {

    @RequestMapping(value = Router.login,method = RequestMethod.GET)
    public String index(){
        return View.login;
    }
}
