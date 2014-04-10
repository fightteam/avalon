package org.fightteam.avalon.security.service;

import org.fightteam.avalon.SpringTest;
import org.fightteam.avalon.security.data.models.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class UserServiceTest extends SpringTest{

    @Autowired
    private UserService userService;

    @Test
    public void test01() throws Exception {
        User user = new User();
        user.setUsername("faith");
        user.setPassword("123456");

        userService.registerUser(user);

    }
}
