package net.bgsystems.sku.web.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:net/bgsystems/sku/config/sku-database.properties" })
public class skuDatabaseConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPackagesToScan(new String[] { "net.bgsystems.sku.business.entity" });
		em.setPersistenceUnitName("sku");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		// Si no tiene un datasource por jndi, intenta levantar los datos desde el properties
		if (!em.getJpaPropertyMap().containsKey("hibernate.connection.datasource"))
			em.setDataSource(dataSource());

		return em;
	}

	//@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("sku.jdbc.driver"));
		dataSource.setUrl(env.getRequiredProperty("sku.jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("sku.jdbc.user"));
		dataSource.setPassword(env.getRequiredProperty("sku.jdbc.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		
		if (env.containsProperty("sku.hibernate.dialect"))
			properties.setProperty("hibernate.dialect", env.getProperty("sku.hibernate.dialect"));
		if (env.containsProperty("sku.hibernate.hbm2ddl.auto"))
			properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("sku.hibernate.hbm2ddl.auto"));
		if (env.containsProperty("sku.hibernate.show_sql"))
			properties.setProperty("hibernate.show_sql", env.getProperty("sku.hibernate.show_sql"));
		if (env.containsProperty("sku.hibernate.format"))
			properties.setProperty("hibernate.format", env.getProperty("sku.hibernate.format"));
		if (env.containsProperty("sku.hibernate.connection.datasource"))
			properties.put("hibernate.connection.datasource", env.getRequiredProperty("sku.hibernate.connection.datasource"));
		
		return properties;
	}
}
