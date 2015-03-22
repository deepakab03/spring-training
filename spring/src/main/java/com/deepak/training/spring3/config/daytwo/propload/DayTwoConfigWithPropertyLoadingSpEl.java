package com.deepak.training.spring3.config.daytwo.propload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.deepak.training.spring3.daytwo.proploading.PropertyLoadingEg;

@Configuration
@Lazy
@PropertySource("classpath:spring-train.properties")
public class DayTwoConfigWithPropertyLoadingSpEl {
    
    //can this be put directly in the PropertyLoadingEg class?
    @Value("${train.db.driverName}") private String trainDbDriver;
    
    //mandatory?
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public PropertyLoadingEg propertyLoadingEg() {
        final PropertyLoadingEg propertyLoadingEg = new PropertyLoadingEg();
        propertyLoadingEg.setDbDriver(trainDbDriver);
        return propertyLoadingEg;
    }
    
}
