package org.fightteam.avalon.mgt;

import org.fightteam.avalon.mgt.vo.UserVO;
import org.fightteam.join.AbstractAppConfig;
import org.fightteam.join.web.AbstractWebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = WebConfig.class,
        includeFilters = {@ComponentScan.Filter(Controller.class),
                @ComponentScan.Filter(ControllerAdvice.class)},
        useDefaultFilters = false)
public class WebConfig extends AbstractWebConfig {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LocaleChangeInterceptor());
//        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
    }

    @Bean
    public ViewResolver resolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/stylesheets").addResourceLocations("/assets/stylesheets").setCachePeriod(0);
        registry.addResourceHandler("/javascripts").addResourceLocations("/assets/javascripts").setCachePeriod(0);
        registry.addResourceHandler("/fonts").addResourceLocations("/assets/fonts").setCachePeriod(0);
        registry.addResourceHandler("/images").addResourceLocations("/assets/images").setCachePeriod(0);
    }

    @Bean
    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory scrf = new SimpleClientHttpRequestFactory();
        scrf.setReadTimeout(3000);
        scrf.setConnectTimeout(3000);
        return scrf;
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory());
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //converter.canRead(UserVO.class, MediaType.APPLICATION_JSON);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
