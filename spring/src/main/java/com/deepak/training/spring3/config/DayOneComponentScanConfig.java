package com.deepak.training.spring3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.deepak.training.spring3.dayone.HelloWorld2;

@Configuration
@ComponentScan(basePackages="com.deepak.training.spring3.dayone")
public class DayOneComponentScanConfig {
    
    @Bean
    public String classpathFileName() {
        return "hw.txt";
    }
    
    //autowiring problems
//    @Bean
//    public String classpathFileName2() {
//        return "hw1.txt";
//    }
//    
//    
//    @Bean
//    public HelloWorld2 helloWorld23() {
//        return new HelloWorld2();
//    }
}
