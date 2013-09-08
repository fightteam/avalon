package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.security.UserDetailsTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 基于spring3.1+的测试
 * User: faith
 * Date: 13-8-1
 * Time: 下午1:07
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:spring-configuration/app-servlet.xml"})
@WebAppConfiguration
public class AppControllerTest extends UserDetailsTest {
    @Autowired
    protected WebApplicationContext wac;
    @Resource
    private FilterChainProxy springSecurityFilterChain;


    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilters(this.springSecurityFilterChain).build();
    }


    @Test
    public void testIndex(){

        ResultActions ra = null;
        try {
            ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        MvcResult mr= ra.andReturn();
        ModelAndView modelAndView = mr.getModelAndView();

        System.out.println(mr);
        System.out.println(modelAndView);
    }

    @Test
    public void signedIn() throws Exception {



        MockHttpSession session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());


        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/register")
                                .session(session));
    }
}
