package org.fightteam.avalon.rest.web;

import org.fightteam.avalon.rest.AbstractWebIntegrationTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * 描述信息
 *
 * @author excalibur
 * @since 0.0.1
 */
public class UserWebTest extends AbstractWebIntegrationTest {

    @Test
    public void testGetAll() throws Exception{
        MvcResult result =mvc.perform(get("/users") //
                .contentType(MediaType.APPLICATION_JSON) //
                ).andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testPost() throws Exception{
        MvcResult result =mvc.perform(post("/users") //
                .contentType(MediaType.APPLICATION_JSON) //
                .content("{\"username\":\"11\",\"password\":\"22\"}"))  //
        .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
    @Test
    public void testGetOne() throws Exception {
        testPost();
        MvcResult result =mvc.perform(get("/users/1") //
                .contentType(MediaType.APPLICATION_JSON) //
        ).andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
