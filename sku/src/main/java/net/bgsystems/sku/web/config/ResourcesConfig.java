package net.bgsystems.sku.web.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:net/bgsystems/sku/config/webservices.properties" })
@PropertySource(value = { "classpath:net/bgsystems/sku/config/resources.properties" })
public class ResourcesConfig {
	private static final Logger LOGGER = LogManager.getLogger(ResourcesConfig.class);

	@Autowired
	private Environment env;

	@Bean(name = "sigla")
	public String getSiglaApp() {
		return env.getProperty("sku.sigla");
	}
}
