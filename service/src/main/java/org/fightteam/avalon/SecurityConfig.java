package org.fightteam.avalon;


import org.fightteam.avalon.security.AvalonSecurityMetadataSource;
import org.fightteam.avalon.security.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author excalibur
* @since 0.0.1
*/
public class SecurityConfig {
    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Configuration
    @EnableWebSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired

        private AvalonSecurityMetadataSource avalonSecurityMetadataSource;

        /**
         * 主要配置哪里载入用户信息
         * 包括信息的验证方式等等
         *
         * @param auth
         * @throws Exception
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            // 在内存中创建一个用户
            // 常用数据库来保持用户
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
            auth.authenticationProvider(provider);

        }




        /**
         * 主要配置哪里录入信息
         * 以及需要权限的资源等
         *
         *
         * 注意使用authorizeRequests().anyRequest().authenticated()开启默认的的资源载入配置
         * 然后配置会被数据库载入的资源替换
         * @param http
         * @throws Exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
            digestAuthenticationEntryPoint.setRealmName("Contacts Realm via Digest Authentication");
            digestAuthenticationEntryPoint.setKey("acegi");
            digestAuthenticationEntryPoint.setNonceValiditySeconds(60);

            DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
            digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
            digestAuthenticationFilter.setUserDetailsService(userDetailsService);

            UserCache userCache = new NullUserCache();
            digestAuthenticationFilter.setUserCache(userCache);

            http.httpBasic()
                    .and()
                    .addFilterAfter(digestAuthenticationFilter, BasicAuthenticationFilter.class)
                    .exceptionHandling().authenticationEntryPoint(digestAuthenticationEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().csrf().disable().authorizeRequests().anyRequest().permitAll();

        }


        @Override
        public void configure(final WebSecurity web) throws Exception {
            // 模块忽略
//        for(Resource resource : resources){
//            if (resource.getResourceType() != ResourceType.MODULE || !resource.isEnable()){
//                continue;
//            }
//            web.ignoring().antMatchers(resource.getName());
//        }
//            final HttpSecurity http = getHttp();
//            web.postBuildAction(new Runnable() {
//                @Override
//                public void run() {
//                    logger.debug("set security avalonSecurityMetadataSource");
//                    System.out.println("-----------------------");
//                    FilterSecurityInterceptor securityInterceptor = http.getSharedObject(FilterSecurityInterceptor.class);
//                    FilterInvocationSecurityMetadataSource metadataSource = securityInterceptor.getSecurityMetadataSource();
//
//
//                    securityInterceptor.setSecurityMetadataSource(avalonSecurityMetadataSource);
//                    System.out.println(securityInterceptor.getAccessDecisionManager());
//                    web.securityInterceptor(securityInterceptor);
//                }
//            });

        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }


    }

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

        @Autowired
        private ResourceService resourceService;


        @Autowired
        private AuthenticationManager authenticationManager;
//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
//        //expressionHandler.setPermissionEvaluator();
//        MethodSecurityMetadataSource methodSecurityMetadataSource;
//
//        return expressionHandler;
//    }


        /**
         * 自定义加载 方法权限规则
         *
         * 目前没进行MetadataSource改造，只是重新读取
         *
         * @return
         */
        @Override
        protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
            Map<String, List<ConfigAttribute>> methodMap = new HashMap<>();

            // 方法权限载入
//        for(Resource resource : resources){
//            if (resource.getResourceType() != ResourceType.METHOD && !resource.isEnable()){
//                continue;
//            }
//
//            List<Permission> permissions = resource.getPermissions();
//            if (permissions.size() == 0){
//                continue;
//            }
//            List<ConfigAttribute> configAttributes = new ArrayList<>();
//            for(Permission permission : permissions){
//                if (!permission.isEnable()){
//                    continue;
//                }
//                configAttributes.add(new SecurityConfig(permission.getName()));
//            }
//            methodMap.put(resource.getName(), configAttributes);
//        }

            MethodSecurityMetadataSource metadataSource = new MapBasedMethodSecurityMetadataSource(methodMap);

            return metadataSource;
        }



        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.parentAuthenticationManager(authenticationManager);
        }
    }


}
