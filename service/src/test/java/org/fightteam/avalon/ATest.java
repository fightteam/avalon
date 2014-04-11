package org.fightteam.avalon;

import org.junit.Test;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SystemWideSaltSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class ATest {
    @Test
    public void test01() throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("123456"));
        System.out.println(passwordEncoder.matches("123456","$2a$10$IYOUapuymSwrAvyHkdD7xOGBg.k440ynJIl8iElgXGYtpJlsbQKbm"));
        System.out.println(passwordEncoder.matches("123456","$2a$10$nPxnv6UlVQxqumrFbSQlVuiNOZQo746lyCi15JQCuh9bWZvVB.A6"));


    }
}
