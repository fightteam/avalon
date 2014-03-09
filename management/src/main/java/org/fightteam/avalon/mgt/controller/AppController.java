package org.fightteam.avalon.mgt.controller;

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
public class AppController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        System.out.println("==============================");
        return "index";
    }
}
