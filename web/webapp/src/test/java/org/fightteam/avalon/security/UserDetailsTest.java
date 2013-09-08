package org.fightteam.avalon.security;

import junit.framework.Assert;
import org.fightteam.avalon.service.UserServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

/**
 * 测试User权限
 * User: faith
 * Date: 13-8-1
 * Time: 下午1:06
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:/spring-configuration/applicationContext-*.xml"})
public class UserDetailsTest extends UserServiceTest{
    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void testLoadUsername(){
        this.testSave();
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.user.getUsername());
        Assert.assertNotNull(userDetails);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUsernameException(){
        this.testSave();
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.user.getUsername()+"2");
        Assert.assertNull(userDetails);
    }



}
