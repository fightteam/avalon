package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.SpringMvcTest;
import org.fightteam.avalon.SpringSecurityTest;
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
public class RegisterControllerTest extends SpringMvcTest {

    @Test
    public void testRegister() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.post("/register").accept(MediaType.ALL)
                .param("username","faith1").param("password","123456"));
        MvcResult mr = ra.andReturn();

        String result = mr.getResponse().getContentAsString();
        System.out.println(result);
    }
}
