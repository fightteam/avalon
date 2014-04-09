package org.fightteam.avalon;

import org.fightteam.join.rest.web.config.AbstractRestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
public class RestConfig extends AbstractRestConfiguration {

     @Override
     protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);

     }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonHttpMessageConverter() {

        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        if (!config().getDefaultMediaType().equals(MediaTypes.HAL_JSON)) {
            mediaTypes.add(MediaType.APPLICATION_JSON);
        }
        mediaTypes.addAll(Arrays.asList(MediaType.valueOf("application/schema+json"),
                MediaType.valueOf("application/x-spring-data-verbose+json"),
                MediaType.valueOf("application/x-spring-data-compact+json")));

        // Configure this mapper to be used if HAL is not the default media type


        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setObjectMapper(objectMapper());
        jacksonConverter.setSupportedMediaTypes(mediaTypes);

        return jacksonConverter;
    }


}
