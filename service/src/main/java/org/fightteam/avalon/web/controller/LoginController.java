package org.fightteam.avalon.web.controller;

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

    @RequestMapping(value = "/login")
    public String aa() {
        System.out.println("0000000000000");
        return "aa";
    }
}
