package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.SpringMvcTest;
import org.fightteam.avalon.SpringSecurityTest;
import org.fightteam.avalon.SpringTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class LoginControllerTest extends SpringSecurityTest {

    @Test
    public void testLogin() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.post("/login").accept(MediaType.ALL)
        .param("username","faith1").param("password","123456"));

        MvcResult mr = ra.andReturn();
        System.out.println(mr);
        System.out.println(mr.getModelAndView());
        String result = mr.getResponse().getContentAsString();
        System.out.println(result);
    }
}
