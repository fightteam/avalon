package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.web.config.Router;
import org.fightteam.avalon.web.config.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 文章控制类
 * User: excalibur
 * Date: 13-8-15
 * Time: 下午9:09
 * 提供对文章的基本操作
 */
@Controller
public class ArticleController {
    @RequestMapping(value = Router.articleManager,method = RequestMethod.GET)
    public String index(){
        return View.articleManager;
    }
}
