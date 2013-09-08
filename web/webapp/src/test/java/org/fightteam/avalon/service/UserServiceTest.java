package org.fightteam.avalon.service;

import junit.framework.Assert;
import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.dao.UserDaoTest;
import org.fightteam.avalon.exception.data.EmailNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 测试UserService类
 * User: faith
 * Date: 13-8-1
 * Time: 上午9:22
 * 测试了UserService的方法
 */
public class UserServiceTest extends UserDaoTest {
    @Autowired
    protected UserService userService;

    @Test(expected = UsernameNotFoundException.class)
    public void testFindByUsernameException() {
        this.testSave();
        User user = userService.findByUsername(this.user.getUsername()+"1");
        Assert.assertNull(user);
    }

    @Test
    public void testFindByUsername() {
        this.testSave();
        User user = userService.findByUsername(this.user.getUsername());
        Assert.assertEquals(this.user.getName(),user.getName());
    }

    @Test(expected = EmailNotFoundException.class)
    public void testFindByEmailException() {
        this.testSave();
        User user = userService.findByEmail(this.user.getEmail()+"1");
        Assert.assertNull(user);
    }

    @Test
    public void testFindByEmail() {
        this.testSave();
        User user = userService.findByEmail(this.user.getEmail());
        Assert.assertEquals(this.user.getName(),user.getName());
    }
}
