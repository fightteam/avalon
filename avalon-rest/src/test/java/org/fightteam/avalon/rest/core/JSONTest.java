package org.fightteam.avalon.rest.core;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.fightteam.avalon.core.entity.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 描述信息
 *
 * @author excalibur
 * @since 0.0.1
 */
public class JSONTest {
    private ObjectMapper objectMapper;
    @Before
    public void setUp(){
        objectMapper = new ObjectMapper();
    }
    @Test
    public void test01() throws Exception{
         User user = new User();
        user.setUsername("faith");
        user.setPassword("1234");

         objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        OutputStream out = System.out;
        JsonGenerator jsonGenerator =
                objectMapper.getJsonFactory().createJsonGenerator(out, JsonEncoding.UTF8);
        this.objectMapper.writeValue(jsonGenerator, user);

    }
}
