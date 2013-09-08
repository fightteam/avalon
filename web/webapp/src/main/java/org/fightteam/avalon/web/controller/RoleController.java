package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.web.config.Router;
import org.fightteam.avalon.web.config.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 角色控制类
 * User: excalibur
 * Date: 13-8-15
 * Time: 下午9:10
 * 提供对角色操作的基本操作
 */
@Controller
public class RoleController {
    @RequestMapping(value = Router.roleManager,method = RequestMethod.GET)
    public String index(){
        return View.roleManager;
    }
}
