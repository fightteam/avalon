package org.fightteam.avalon.test;

import org.fightteam.avalon.ApplicationConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 容器初始化测试类
 * User: faith
 * Date: 13-7-2
 * Time: 下午6:03
 * 主要实例化spring
 * 继承AbstractJUnit4SpringContextTests实现
 */
//@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public abstract class AbstractIntegrationTest {
}
