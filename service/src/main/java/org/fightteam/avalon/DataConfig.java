package org.fightteam.avalon;

import org.fightteam.join.dao.AbstractDataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableJpaRepositories(basePackages = "org.fightteam.avalon")
@EnableTransactionManagement
public class DataConfig extends AbstractDataConfig {
    private final static Logger log = LoggerFactory.getLogger(DataConfig.class);


}
