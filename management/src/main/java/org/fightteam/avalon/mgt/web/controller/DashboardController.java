package org.fightteam.avalon.mgt.web.controller;

import org.fightteam.avalon.mgt.web.common.Routers;
import org.fightteam.avalon.mgt.web.common.Views;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DashboardController {

    @RequestMapping(value = Routers.dashboard, method = RequestMethod.GET)
    public String index(){

        return Views.dashboard;
    }
}
