package org.fightteam.avalon.security.service;

import org.fightteam.avalon.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.util.FieldUtils;

import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class ResourceServiceTest extends SpringTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void test01() throws Exception {
//        resourceService.add();
        Map<String, String> map = resourceService.findAllURL();
        for(String k : map.keySet()){
            System.out.println(k);
            System.out.println(map.get(k));
        }

    }
}
