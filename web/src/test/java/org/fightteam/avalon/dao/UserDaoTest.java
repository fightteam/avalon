package org.fightteam.avalon.dao;

import junit.framework.Assert;
import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.entity.EntityTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserDao测试类
 * User: faith
 * Date: 13-8-1
 * Time: 上午9:48
 * 保证UserDao的方法运行正确
 * 只是部分测试，因为采用了spring data
 * 有的方法根本没有必要测试
 */
public class UserDaoTest extends EntityTest{
    @Autowired
    protected UserDao userDao;
    //=====================测试数据环境============================
    // 为了方便继承类使用
    protected User user;
    @Before
    public void setUp(){
        user = new User();
        user.setUsername("excalibur");
        user.setPassword("123456");
        user.setName("刘真源");
        user.setEmail("lzy7750015@qq.com");
    }
    @Test
    public void testSave(){
        user = userDao.save(user);
        //断言user中有id 因为存储成功后会返回id
        Assert.assertNotNull(user.getId()); // #1
    }
    @Test
    public void testUpdate(){
        this.testSave();
        user.setName("excalibur");
        user = userDao.save(user);
        Assert.assertEquals("excalibur",user.getName());
    }
    @Test
    public void testFindByUsername(){
        this.testSave();
        User user = userDao.findByUsername(this.user.getUsername());
        Assert.assertNotNull(user);
    }
    @Test
    public void testFindByEmail(){
        this.testSave();
        User user = userDao.findByEmail(this.user.getEmail());
        Assert.assertNotNull(user);
    }
}
