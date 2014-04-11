package org.fightteam.avalon.security.service;

import org.fightteam.avalon.SpringTest;
import org.fightteam.avalon.security.data.models.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SystemWideSaltSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class UserServiceTest extends SpringTest{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void test01() throws Exception {

        userDetailsService.loadUserByUsername("faith");


    }

    @Test
    public void test02() throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        // 盐值 固定盐值
        SystemWideSaltSource saltSource = new SystemWideSaltSource();
        saltSource.setSystemWideSalt("lzy7750015");
        provider.setSaltSource(null);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        provider.setPasswordEncoder(passwordEncoder);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("faith","123456");
        provider.authenticate(token);

    }
}
