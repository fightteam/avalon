package org.fightteam.avalon;

import org.fightteam.join.AbstractAppConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableAsync
@EnableAspectJAutoProxy
public class AppConfig extends AbstractAppConfig {


}
