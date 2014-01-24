package org.fightteam.avalon.data.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class ResourceTypeTest {

    @Test
    public void testToString(){
        Assert.assertEquals("ACL限制", ResourceType.ACL.toString());
    }
}
