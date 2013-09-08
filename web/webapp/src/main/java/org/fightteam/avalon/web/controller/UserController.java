package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.service.UserService;
import org.fightteam.avalon.web.config.Router;
import org.fightteam.avalon.web.config.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制类
 * User: excalibur
 * Date: 13-8-15
 * Time: 下午8:58
 * 提供对用户基本的操作
 */
@Controller
public class UserController {
    @RequestMapping(value = Router.userManager,method = RequestMethod.GET)
    public String index(){
        return View.userManager;
    }
}
