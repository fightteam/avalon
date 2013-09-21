package org.fightteam.avalon.core;

import org.fightteam.avalon.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试集成
 *
 * 抽象定义 继承方便测试
 *
 * @author excalibur
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ApplicationConfig.class)
@Transactional
@ActiveProfiles("test")
public class AbstractIntegrationTest {
    @Test
    public void testInit(){

    }
}
