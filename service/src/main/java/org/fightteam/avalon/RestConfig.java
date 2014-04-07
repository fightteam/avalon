package org.fightteam.avalon;

import org.fightteam.join.rest.web.config.AbstractRestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
public class RestConfig extends AbstractRestConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.setDefaultMediaType(MediaType.APPLICATION_JSON);

    }


}
