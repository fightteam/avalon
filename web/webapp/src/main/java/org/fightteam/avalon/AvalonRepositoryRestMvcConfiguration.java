package org.fightteam.avalon;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: excalibur
 * Date: 13-8-22
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class AvalonRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration{

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        System.out.println("******************");
        System.out.println("******************");
        // 设置基础路径
        URI uri = null;
        try {
            uri = new URI("http://localhost:8080/api");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        config.setBaseUri(uri);
    }

}
