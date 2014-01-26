package org.fightteam.avalon;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 主要配置哪里载入用户信息
     * 包括信息的验证方式等等
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中创建一个用户
//        常用数据库来保持用户
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
        //auth.userDetailsService(new UserService());
    }


    /**
     * 主要配置哪里录入信息
     * 以及需要权限的资源等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
