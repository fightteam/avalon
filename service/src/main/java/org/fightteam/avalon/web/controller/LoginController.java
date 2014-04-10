package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.security.data.models.Resource;
import org.fightteam.avalon.security.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Controller
public class LoginController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/login")
    public String aa() {
        System.out.println("0000000000000");
        resourceService.findAllURL();
        return "aa";
    }
}
