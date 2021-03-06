package org.fightteam.avalon;

import org.fightteam.join.dao.AbstractDataConfig;
import org.fightteam.join.test.AbstractIntegrationTest;
import org.fightteam.join.test.AbstractWebIntegrationTest;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ContextConfiguration(classes = {AppConfig.class,
        SpringTest.TestDataConfig.class})
public class SpringTest extends AbstractIntegrationTest {



    @Before
    public void setUp() throws Exception {

    }

    @Configuration
    @EnableJpaRepositories(basePackages = "org.fightteam")
    @EnableTransactionManagement
    public static class TestDataConfig extends AbstractDataConfig {
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