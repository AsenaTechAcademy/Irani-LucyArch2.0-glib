
package org.asena.baseService;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "org.asena.edu.Service", "org.asena.edu.Controller", "org.asena.glib.Service", "org.asena.glib.Controller",
		"org.asena.baseService", "org.asena.AAA" })
@EnableTransactionManagement
public class ApplicationConfig
{
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.asena.edu.Entity", "org.asena.glib.Entity", "org.asena.AAA.Entity" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/glib");
		dataSource.setUsername("glibadmin");
		dataSource.setPassword("123");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}


	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
	{
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties additionalProperties()
	{
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}


}


