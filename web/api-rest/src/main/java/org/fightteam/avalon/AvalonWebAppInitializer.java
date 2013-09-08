package org.fightteam.avalon;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 基于Servlet3.0的 web配置
 * User: excalibur
 * Date: 13-9-7
 * Time: 下午2:04
 *
 */
public class AvalonWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置载入RootConfig配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { ApplicationConfig.class };
    }

    /**
     * 配置载入Servlet
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfiguration.class };
    }

    /**
     * 配置Servlet 的mapping
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected javax.servlet.Filter[] getServletFilters() {
        return new javax.servlet.Filter[] { new OpenEntityManagerInViewFilter()};
    }


    /**
     * Web layer configuration enabling Spring MVC, Spring Hateoas hypermedia support.
     *
     * @author Oliver Gierke
     */
    @Configuration
    @EnableHypermediaSupport
    @Import(AvalonRepositoryRestMvcConfiguration.class)
    @ComponentScan(excludeFilters = @ComponentScan.Filter({ Service.class, Configuration.class }))
    public static class WebConfiguration extends DelegatingWebMvcConfiguration {


        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.defaultContentType(MediaType.APPLICATION_JSON);
        }


    }
}
