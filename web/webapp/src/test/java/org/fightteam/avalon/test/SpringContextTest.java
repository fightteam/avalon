package org.fightteam.avalon.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Spring 容器初始化测试类
 * User: faith
 * Date: 13-7-2
 * Time: 下午6:03
 * 主要实例化spring
 * 继承AbstractJUnit4SpringContextTests实现
 */
@ActiveProfiles("test")
public class SpringContextTest extends AbstractJUnit4SpringContextTests {
}
