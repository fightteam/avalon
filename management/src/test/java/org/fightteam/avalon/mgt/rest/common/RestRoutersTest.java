package org.fightteam.avalon.mgt.rest.common;

import org.fightteam.avalon.mgt.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class RestRoutersTest extends SpringTest{

    @Autowired
    private RestRouters restRouters;

    @Test
    public void testUsers() throws Exception {
        System.out.println(restRouters.getUsers());
    }
}
