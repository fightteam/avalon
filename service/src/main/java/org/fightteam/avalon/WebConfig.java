package org.fightteam.avalon;

import org.fightteam.join.web.AbstractWebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
* [description]
*
* @author faith
* @since 0.0.1
*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = WebConfig.class,
        includeFilters = {@ComponentScan.Filter(Controller.class),
                @ComponentScan.Filter(ControllerAdvice.class)},
        useDefaultFilters = false)
public class WebConfig extends AbstractWebConfig {

//    @Bean
//    public ViewResolver resolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
}
