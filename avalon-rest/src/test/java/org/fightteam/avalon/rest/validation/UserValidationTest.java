package org.fightteam.avalon.rest.validation;

import org.fightteam.avalon.rest.AbstractWebIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/** 
* UserValidation Tester. 
* 
* @author excalibur
* @since 0.0.1
*/
public class UserValidationTest extends AbstractWebIntegrationTest {


    @Test
    public void testValidate() throws Exception {
//        String a = context.getMessage("not.blank", null, Locale.getDefault());
//        System.out.println(a);

        MvcResult result = mvc.perform(post("/users") //
                .contentType(MediaType.APPLICATION_JSON) //
                .content("{\"username\":\"11\"}")).andReturn();
//        MockHttpServletResponse response = mvc.perform(get("/")). //
//                andExpect(status().isOk()).
//                andReturn().getResponse();
//        System.out.println(response.getContentAsString());
        System.out.println(result.getResponse().getContentAsString());
    }


} 
