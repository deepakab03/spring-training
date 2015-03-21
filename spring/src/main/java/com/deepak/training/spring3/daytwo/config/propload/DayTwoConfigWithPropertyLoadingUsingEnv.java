package com.deepak.training.spring3.daytwo.config.propload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.deepak.training.spring3.daytwo.proploading.PropertyLoadingEg;

/**
 * Not the preferred way anymore
 * 
 * @author abrahd2
 *
 */
@Configuration
@Lazy
@PropertySource("classpath:spring-train.properties")
public class DayTwoConfigWithPropertyLoadingUsingEnv {
    @Autowired private Environment env;
    
    @Bean
    public PropertyLoadingEg propertyLoadingEg() {
        final PropertyLoadingEg propertyLoadingEg = new PropertyLoadingEg();
        final String dbDriver = env.getProperty("train.db.driverName");
        propertyLoadingEg.setDbDriver(dbDriver);
        //overloaded methods?
        //required property?
        
        return propertyLoadingEg;
    }
}
