package com.philipp.note.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.philipp.note.model.ToDo;
import com.philipp.note.model.User;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.philipp.note.dao"),
		@ComponentScan("com.philipp.note.service") })
public class AppConfig {

	   @Autowired
	   private Environment env;

	   @Bean(name = "dataSource")
	   @Primary
	   public DataSource getDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("mysql.driver"));
	      dataSource.setUrl(env.getProperty("mysql.url"));
	      dataSource.setUsername(env.getProperty("mysql.user"));
	      dataSource.setPassword(env.getProperty("mysql.password"));
	      return dataSource;
	   }

	   @Bean
	   @Primary
	   public LocalSessionFactoryBean getSessionFactory() {
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	      factoryBean.setDataSource(getDataSource());
	      
	      Properties props=new Properties();
	      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	      props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

	      factoryBean.setHibernateProperties(props);
	      Class[] classes = new Class[] {ToDo.class, User.class};
	      factoryBean.setAnnotatedClasses(classes);
	      return factoryBean;
	   }

	   @Bean
	   @Primary
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getSessionFactory().getObject());
	      return transactionManager;
	   }
}