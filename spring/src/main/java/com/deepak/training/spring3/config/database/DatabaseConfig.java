package com.deepak.training.spring3.config.database;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.deepak.training.spring3.config.daytwo.propload.PropertiesConfig;
import com.deepak.training.spring3.database.JdbcDao;

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
	public DataSource trainingDbDataSource() {
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
	public JdbcDao jdbcDao() {
	    return new JdbcDao();
	}
	
}
