package org.fightteam.avalon;

import org.fightteam.join.dao.AbstractDataConfig;
import org.fightteam.join.test.AbstractIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {SpringTest.AppConfig.class, SpringTest.DataConfig.class})
public class SpringTest extends AbstractIntegrationTest {

    @Configuration
    @ComponentScan(basePackageClasses = AppConfig.class)
    @EnableAsync
    public static class AppConfig{

    }

    @Configuration
    @EnableJpaRepositories(basePackages = "org.fightteam")
    @EnableTransactionManagement
    public static class DataConfig extends AbstractDataConfig {
        @Bean
        @Override
        public DataSource dataSource() {
            setDatabaseType(Database.MYSQL);
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/avalon");
            driverManagerDataSource.setUsername("root");
            driverManagerDataSource.setPassword("root");

            return driverManagerDataSource;
        }
    }
}