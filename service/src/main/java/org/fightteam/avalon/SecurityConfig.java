package org.fightteam.avalon;


import org.fightteam.avalon.security.AvalonSecurityMetadataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
//    @Qualifier("userServiceImpl")
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
//        常用数据库来保持用户
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        auth.authenticationProvider(provider);
    }




    /**
     * 主要配置哪里录入信息
     * 以及需要权限的资源等
     *
     * @param http
     * @throws Exception
     */
    @Transactional
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
        .and().csrf().disable().authorizeRequests().anyRequest().authenticated();

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

                FilterSecurityInterceptor securityInterceptor = http.getSharedObject(FilterSecurityInterceptor.class);
                FilterInvocationSecurityMetadataSource metadataSource = securityInterceptor.getSecurityMetadataSource();

                avalonSecurityMetadataSource.setDefaultSecurityMetadataSource(metadataSource);
                securityInterceptor.setSecurityMetadataSource(avalonSecurityMetadataSource);
                web.securityInterceptor(securityInterceptor);






            }
        });

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
