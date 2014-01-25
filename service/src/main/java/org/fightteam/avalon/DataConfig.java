package org.fightteam.avalon;

import org.fightteam.join.dao.AbstractDataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@ComponentScan(basePackageClasses = DataConfig.class)
@EnableJpaRepositories
@EnableTransactionManagement
public class DataConfig extends AbstractDataConfig {
    private final static Logger log = LoggerFactory.getLogger(DataConfig.class);
    @Autowired
    private Environment environment;

    private Database databaseType;
    @Bean
    public DataSource dataSource() {
//        String url = environment.getProperty("database.url");
//        if (url.indexOf(":hsqldb:") != -1){
//            databaseType = Database.HSQL;
//            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//            return builder.setType(EmbeddedDatabaseType.HSQL).build();
//        } else if (url.indexOf(":mysql:") != -1){
//            databaseType = Database.MYSQL;
//        } else if (url.indexOf(":microsoft:sqlserver:") != -1){
//            databaseType = Database.SQL_SERVER;
//        } else if (url.indexOf(":oracle:thin:") != -1){
//            databaseType = Database.ORACLE;
//        }
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context)ctx.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/database");
            return ds;
        } catch (NamingException e) {
            log.error("create data source error",e);
        }
        return null;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(getClass().getPackage().getName());
        factory.setDataSource(dataSource());

        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

}
