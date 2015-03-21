package com.deepak.training.spring3.daytwo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.deepak.training.spring3.daytwo.PropertyLoadingUsingEnvEg;

@Configuration
@Lazy
@Import(DayTwoConfig.class)
@PropertySource("classpath:spring-train.properties")
public class DayTwoConfigWithPropertyLoadingUsingEnv {
    @Autowired private Environment env;
    
    @Bean
    public PropertyLoadingUsingEnvEg propertyLoadingEg() {
        final PropertyLoadingUsingEnvEg propertyLoadingEg = new PropertyLoadingUsingEnvEg();
        final String dbDriver = env.getProperty("train.db.driverName");
        propertyLoadingEg.setDbDriver(dbDriver);
        //overloaded methods?
        //required property?
        
        return propertyLoadingEg;
    }
}
