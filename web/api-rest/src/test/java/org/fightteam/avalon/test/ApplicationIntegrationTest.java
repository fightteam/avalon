package org.fightteam.avalon.test;

import org.fightteam.avalon.AvalonWebAppInitializer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: excalibur
 * Date: 13-9-7
 * Time: 下午6:18
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void initializesRootApplicationContext() {
        new Repositories(context);
    }

    @Test
    public void initializesWebApplicationContext() {

        AnnotationConfigWebApplicationContext applicationContext = null;

        try {

            applicationContext = new AnnotationConfigWebApplicationContext();
            applicationContext.setServletContext(new MockServletContext());
            applicationContext.register(AvalonWebAppInitializer.WebConfiguration.class);
            applicationContext.setParent(context);
            applicationContext.refresh();

        } finally {

            if (applicationContext != null) {
                applicationContext.close();
            }
        }
    }
}
