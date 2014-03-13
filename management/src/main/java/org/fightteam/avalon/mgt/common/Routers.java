package org.fightteam.avalon.mgt.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Getter
@Setter
public class Routers {

    @Value("${rest.users}")
    private String users;

    @Value("${rest.roles}")
    private String roles;
}
