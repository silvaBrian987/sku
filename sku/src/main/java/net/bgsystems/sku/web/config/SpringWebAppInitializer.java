package net.bgsystems.sku.web.config;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {
	private Logger LOGGER;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		configureLogger();
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/servicios/*");
		dispatcher.setAsyncSupported(true);
	}
	
	private void configureLogger() {
		System.setProperty("log4j.configurationFile", "net/bgsystems/sku/config/log4j2.xml");
		LOGGER = Logger.getLogger(SpringWebAppInitializer.class.getName());
	}

}
