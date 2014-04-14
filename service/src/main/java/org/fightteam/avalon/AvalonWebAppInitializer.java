package org.fightteam.avalon;

import org.fightteam.avalon.web.filter.CORSFilter;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class AvalonWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class,
                DataConfig.class,
                SecurityConfig.WebSecurityConfig.class,
//                SecurityConfig.MethodSecurityConfig.class,
                RestConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{ new CORSFilter()};
//    }


}
