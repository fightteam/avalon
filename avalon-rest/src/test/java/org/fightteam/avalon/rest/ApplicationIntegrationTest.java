package org.fightteam.avalon.rest;

import org.fightteam.avalon.core.AbstractIntegrationTest;
import org.fightteam.avalon.rest.WebAppInitializer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
/**
 * Integration test to bootstrap the root {@link org.springframework.context.ApplicationContext}.
 * 
 * @author Oliver Gierke
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
			applicationContext.register(WebAppInitializer.WebConfiguration.class);
			applicationContext.setParent(context);
			applicationContext.refresh();

		} finally {

			if (applicationContext != null) {
				applicationContext.close();
			}
		}
	}
}
