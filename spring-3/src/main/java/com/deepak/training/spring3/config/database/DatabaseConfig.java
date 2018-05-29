package com.deepak.training.spring3.config.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.deepak.training.spring3.config.daytwo.propload.PropertiesConfig;
import com.deepak.training.spring3.database.PetDao;
import com.deepak.training.spring3.database.PetHibernateDao;
import com.deepak.training.spring3.database.PetJdbcDao;
import com.deepak.training.spring3.database.PetSpringJdbcDaoImpl;

@Configuration
@Lazy
@Import(PropertiesConfig.class)
@PropertySource("classpath:spring-train.properties")
public class DatabaseConfig {
    
    @Autowired private PropertiesConfig propertiesConfig;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
	@Bean
	DataSource trainingDbDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(propertiesConfig.getTrainingDbDriverClass());
		dataSource.setUrl(propertiesConfig.getTrainingDbUrl());
		dataSource.setUsername(propertiesConfig.getTrainingDbUsername());
		dataSource.setPassword(propertiesConfig.getTrainingDbPassword());
		
		dataSource.setInitialSize(1);
		dataSource.setMaxTotal(2);
		
		return dataSource;
	}
	
	@Bean
    NamedParameterJdbcTemplate trainingDbNamedParameterJdbcTemplate() {
	    return new NamedParameterJdbcTemplate(trainingDbDataSource());
	}
	
	@Bean
	public LocalSessionFactoryBean trainingdDbSessionFactory() {
	    LocalSessionFactoryBean lsb = new LocalSessionFactoryBean();
	    lsb.setDataSource(trainingDbDataSource());
	    
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
	    lsb.setHibernateProperties(hibernateProperties);
	    
	    lsb.setMappingResources("com/deepak/training/spring3/model/Pet.hbm.xml");
	    
        return lsb;
    }
	
	//required always?
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//	    return new HibernateTransactionManager(trainingdDbSessionFactory().getObject());
//	}

	@Bean
    HibernateTemplate trainingDbHibernateTemplate() {
        return new HibernateTemplate(trainingdDbSessionFactory().getObject());
    }
	
	@Bean
    public PetJdbcDao petJdbcDao() {
        return new PetJdbcDao();
    }
    
    @Bean
    public PetDao petSpringJdbcDao() {
        return new PetSpringJdbcDaoImpl(trainingDbNamedParameterJdbcTemplate());
    }
    
    @Bean
    public PetDao petHibernateDao() {
        return new PetHibernateDao(trainingDbHibernateTemplate());
    }
	
}
