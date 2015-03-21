package com.deepak.training.spring3.daytwo.config.propload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.deepak.training.spring3.daytwo.proploading.PropertyLoadingUsingPropertiesConfig;

@Configuration
@Lazy
@PropertySource("classpath:spring-train.properties")
@Import(PropertiesConfig.class)
public class DayTwoConfigWithPropertyLoadingUsingPropertiesConfig {
    
    @Autowired private PropertiesConfig propertiesConfig;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public PropertyLoadingUsingPropertiesConfig propertyLoadingEg() {
        final PropertyLoadingUsingPropertiesConfig propertyLoadingEg = new PropertyLoadingUsingPropertiesConfig(propertiesConfig.getTrainDbDriverName());
        propertyLoadingEg.setConfigProperties(propertiesConfig);
        return propertyLoadingEg;
    }
    
}