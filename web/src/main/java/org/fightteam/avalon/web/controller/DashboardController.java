package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.web.config.Router;
import org.fightteam.avalon.web.config.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: faith
 * Date: 13-8-13
 * Time: 上午9:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DashboardController {

    @RequestMapping(value = Router.dashboard)
    public String index(Model model){
        System.out.println(model);
        return View.dashboard;
    }
}
