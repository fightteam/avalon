package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.web.config.Router;
import org.fightteam.avalon.web.config.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统资源控制类
 * User: excalibur
 * Date: 13-8-15
 * Time: 下午8:58
 * 提供对系统资源的基本操作
 */
@Controller
public class ResourceController {

    @RequestMapping(value = Router.resourceManager,method = RequestMethod.GET)
    public String index(){
        return View.resourceManager;
    }
}
