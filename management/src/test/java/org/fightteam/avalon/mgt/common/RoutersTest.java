package org.fightteam.avalon.mgt.common;

import org.fightteam.avalon.mgt.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class RoutersTest extends SpringTest{

    @Autowired
    private Routers routers;

    @Test
    public void testUsers() throws Exception {
        System.out.println(routers.getUsers());
    }
}
