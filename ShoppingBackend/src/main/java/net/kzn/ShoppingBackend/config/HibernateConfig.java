package net.kzn.ShoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="{net.kzn.ShoppingBackend.dto}")
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/online_shopping";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";

	@Bean
	public DataSource getDatasource(){

		BasicDataSource basicDatasource=new BasicDataSource();
		basicDatasource.setDriverClassName(DATABASE_DRIVER);
		basicDatasource.setUrl(DATABASE_URL);
		basicDatasource.setUsername(DATABASE_USERNAME);
		basicDatasource.setPassword(DATABASE_PASSWORD);

		return basicDatasource;

	}

	//SessionFaction

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder =new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzn.ShoppingBackend.dto");
		return builder.buildSessionFactory();

	}
	
	//All the Hibernate Properties 
	public Properties getHibernateProperties() {
		
		Properties properties=new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.format_sql","true");
		
		
		return properties;
	}

	//Trasaction Manager
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
	
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}


}
