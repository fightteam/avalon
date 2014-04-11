package org.fightteam.avalon.security;

import org.fightteam.avalon.SpringMvcTest;
import org.fightteam.avalon.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class AvalonSecurityMetadataSourceTest extends SpringMvcTest {



    @Autowired
    private AvalonSecurityMetadataSource avalonSecurityMetadataSource;

    @Test
    public void test01() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL));

        MvcResult mr = ra.andReturn();
        System.out.println(mr);
        System.out.println(mr.getModelAndView());
        String result = mr.getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void test02() throws Exception {
        List<ConfigAttribute> configAttributes =  SecurityConfig.createListFromCommaDelimitedString("hasAuthority('GETRESPOSITORY'),hasRole('ADMIN')");
        System.out.println(configAttributes);
    }
}
