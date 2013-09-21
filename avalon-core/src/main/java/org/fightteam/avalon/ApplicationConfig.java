package org.fightteam.avalon;


import org.apache.commons.dbcp.BasicDataSource;
import org.fightteam.avalon.helper.DataSourceHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Avalon系统环境基本配置，基于spring 3.2 及以上。这是系统大多数环境配置的地方，包括数据源、实体工厂、事务等等
 *
 *
 * 部分配置参考于@see https://github.com/doles/spring-data-rest-security-configuration
 * @author excalibur
 * @since 0.0.1
 */
@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(Service.class), useDefaultFilters = false,
        basePackageClasses = ApplicationConfig.class)
@EnableAsync
@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableTransactionManagement
@Import({ApplicationConfig.TestProfileConfig.class,
        ApplicationConfig.DevelopmentProfileConfig.class,
        ApplicationConfig.ProductionProfileConfig.class})
@PropertySource("classpath:/props/application.properties")
public class ApplicationConfig {
    private final static Logger log = null;
    @Autowired
    private Environment environment;
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void setup(){

    }


    /**
     * 实例化JPA实例工厂
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(DataSourceHelper.getDatabase(dataSource));
        boolean generateDdl = true;
        try {
           generateDdl = Boolean.parseBoolean(environment.getProperty("hibernate.generateddl"));
        } catch (Exception e) {
            log.error("parseBoolean {} error", generateDdl);
        }
        vendorAdapter.setGenerateDdl(generateDdl);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(getClass().getPackage().getName());
        factory.setDataSource(dataSource);

        return factory;
    }

    /**
     * 实例化事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    /**
     * 定义Test环境配置
     */
    @PropertySource("classpath:/props/env.test.properties")
    @Profile("test")
    public static class TestProfileConfig{
        @Autowired
        private Environment environment;
        /**
         * 根据url来判断实例化数据库 以便支持测试登环境
         * 单元测试采用嵌入型数据库
         * @return
         */
        @Bean
        public DataSource dataSource() {
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder.setType(EmbeddedDatabaseType.HSQL).build();
        }
    }

    /**
     * 定义development环境配置
     */
    @PropertySource("classpath:/props/env.development.properties")
    @Profile("development")
    public static class DevelopmentProfileConfig{
        @Autowired
        private Environment environment;
        /**
         * 根据url来判断实例化数据库 以便支持测试登环境
         * 单元测试采用嵌入型数据库
         * @return
         */
        @Bean
        public DataSource dataSource() {
            // 配置DBCP数据库连接池
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(environment.getProperty("dataSource.driverClassName"));
            dataSource.setUrl(environment.getProperty("dataSource.url"));
            dataSource.setUsername(environment.getProperty("dataSource.username"));
            dataSource.setPassword(environment.getProperty("dataSource.password"));
            return dataSource;
        }
    }
    /**
     * 定义production环境配置
     */
    @PropertySource("classpath:/props/env.production.properties")
    @Profile("production")
    public static class ProductionProfileConfig{
        @Autowired
        private Environment environment;
        /**
         * 根据url来判断实例化数据库 以便支持测试登环境
         * 单元测试采用嵌入型数据库
         * @return
         */
        @Bean
        public DataSource dataSource() {


            // 配置DBCP数据库连接池
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(environment.getProperty("dataSource.driverClassName"));
            dataSource.setUrl(environment.getProperty("dataSource.url"));
            dataSource.setUsername(environment.getProperty("dataSource.username"));
            dataSource.setPassword(environment.getProperty("dataSource.password"));
            return dataSource;
        }
    }
}
