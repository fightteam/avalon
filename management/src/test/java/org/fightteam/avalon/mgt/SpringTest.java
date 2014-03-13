package org.fightteam.avalon.mgt;

import org.fightteam.join.test.AbstractRestIntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class SpringTest extends AbstractRestIntegrationTest {

}
