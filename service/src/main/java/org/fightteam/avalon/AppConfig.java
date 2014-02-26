package org.fightteam.avalon;

import org.fightteam.join.AbstractAppConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 项目配置
 *
 * 主要载入了一些配置参数
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@ComponentScan(basePackages = "org.fightteam", excludeFilters = {@ComponentScan.Filter({Controller.class}), @ComponentScan.Filter({ControllerAdvice.class})})
@PropertySource(value = "classpath:app.properties")
public class AppConfig extends AbstractAppConfig {


}
