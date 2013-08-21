package org.fightteam.avalon.entity;

import org.fightteam.avalon.test.SpringContextTest;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 实例化spring
 * User: faith
 * Date: 13-7-2
 * Time: 下午1:36
 *  测试实体关系是否正确
 */
@DirtiesContext
@ContextConfiguration(locations = {"classpath:/spring-configuration/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
public class EntityTest extends SpringContextTest{

    @Test
    public void testInit(){

    }
}
