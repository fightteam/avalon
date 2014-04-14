package org.fightteam.avalon;


import org.fightteam.avalon.security.AvalonMethodSecurityMetadataSource;
import org.fightteam.avalon.security.AvalonSecurityMetadataSource;
import org.fightteam.avalon.security.AvalonUsernamePasswordAuthenticationFilter;
import org.fightteam.avalon.security.authentication.AvalonAuthenticationSuccessHandler;
import org.fightteam.avalon.security.authentication.AvalonBasicAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
* @author excalibur
* @since 0.0.1
*/
public class SecurityConfig {
    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Configuration("webSecurityConfig")
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
        @Autowired
        protected void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            // 在内存中创建一个用户
            // 常用数据库来保持用户
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
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
//            DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
//            digestAuthenticationEntryPoint.setRealmName("Contacts Realm via Digest Authentication");
//            digestAuthenticationEntryPoint.setKey("acegi");
//            digestAuthenticationEntryPoint.setNonceValiditySeconds(60);
//
//            DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
//            digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
//            digestAuthenticationFilter.setUserDetailsService(userDetailsService);
//
//            UserCache userCache = new NullUserCache();
//            digestAuthenticationFilter.setUserCache(userCache);
            AvalonBasicAuthenticationEntryPoint entryPoint = new AvalonBasicAuthenticationEntryPoint();
            AvalonUsernamePasswordAuthenticationFilter authenticationFilter = new AvalonUsernamePasswordAuthenticationFilter();
            authenticationFilter.setAuthenticationManager(authenticationManagerBean());

            AvalonAuthenticationSuccessHandler successHandler = new AvalonAuthenticationSuccessHandler();
            successHandler.setPasswordEncoder(passwordEncoder());

            authenticationFilter.setAuthenticationSuccessHandler(successHandler);

            http.formLogin().and().addFilterBefore(authenticationFilter,UsernamePasswordAuthenticationFilter.class)
//                    .and()
//                    .addFilterAfter(digestAuthenticationFilter, BasicAuthenticationFilter.class)
//                    .exceptionHandling().authenticationEntryPoint(digestAuthenticationEntryPoint)
//                    .and()
                    .exceptionHandling().authenticationEntryPoint(entryPoint).and()
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

            final HttpSecurity http = getHttp();
            web.postBuildAction(new Runnable() {
                @Override
                public void run() {
                    logger.debug("set security avalonSecurityMetadataSource");
                    System.out.println("-----------------------");
                    FilterSecurityInterceptor securityInterceptor = http.getSharedObject(FilterSecurityInterceptor.class);
                    FilterInvocationSecurityMetadataSource metadataSource = securityInterceptor.getSecurityMetadataSource();


                    securityInterceptor.setSecurityMetadataSource(avalonSecurityMetadataSource);
                    System.out.println(securityInterceptor.getAccessDecisionManager());
                    web.securityInterceptor(securityInterceptor);
                    System.out.println(web.getObject());
                    System.out.println(web);
                }
            });

        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {

            return super.authenticationManagerBean();
        }


    }

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    @Lazy
    public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

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

        @Bean
        public AvalonMethodSecurityMetadataSource avalonMethodSecurityMetadataSource(){
            return new AvalonMethodSecurityMetadataSource();
        }

        /**
         * 自定义加载 方法权限规则
         *
         * 目前没进行MetadataSource改造，只是重新读取
         *
         * @return
         */
        @Override
        protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {

            return avalonMethodSecurityMetadataSource();
        }



        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.parentAuthenticationManager(authenticationManager);
        }
    }


}
