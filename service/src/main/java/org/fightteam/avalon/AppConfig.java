package org.fightteam.avalon;

import org.fightteam.join.AbstractAppConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 项目配置
 *
 * 主要载入了一些配置参数
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@PropertySource(value = "classpath:app.properties")
public class AppConfig extends AbstractAppConfig {

    /**
     * 载入信息提示消息
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/i18n/message");
        // 不使用国际化
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }
}
