package org.fightteam.avalon.other;

import org.fightteam.avalon.web.controller.AppControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.tags.MessageTag;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: faith
 * Date: 13-8-12
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class MessageResourceTest extends AppControllerTest {

    @Autowired
    private SimpleUrlHandlerMapping handlerMappingC;
    @Autowired
    private InternalResourceViewResolver viewResolver;
    @Test
    public void textMessage(){
        System.out.println(wac.getMessage("application.services.title",null, Locale.SIMPLIFIED_CHINESE));
        System.out.println(wac.getMessage("application.services.title",null, Locale.ENGLISH));
        System.out.println(wac.getMessage("application.services.title",null, Locale.getDefault()));

    }
    @Test
    public void textThem(){


        System.out.println(handlerMappingC.getUrlMap().get("/"));
        System.out.println(viewResolver.getAttributesMap().size());
    }
}
