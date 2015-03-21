package com.deepak.training.spring3.daytwo.config.propload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Lazy
@PropertySource("classpath:spring-train.properties")
@ComponentScan(basePackages="com.deepak.training.spring3.")
public class DayTwoConfigWithPropertyLoadingComponentScan {
    
    //mandatory?
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
