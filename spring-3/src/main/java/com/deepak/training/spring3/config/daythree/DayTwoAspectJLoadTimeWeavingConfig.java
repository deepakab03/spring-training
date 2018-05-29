package com.deepak.training.spring3.config.daythree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import com.deepak.training.spring3.daytwo.SomeService;

@Configuration
@EnableSpringConfigured
public class DayTwoAspectJLoadTimeWeavingConfig {

    @Bean
    public SomeService someService() {
       return new SomeService();
    }
    
//    @Bean
//    @Scope("prototype")
//    public NonSpringBeanInjection nonSpringBeanInjection() {
//       NonSpringBeanInjection nonSpringBeanInjection = new NonSpringBeanInjection();
//       nonSpringBeanInjection.setName("Tarun");
//       nonSpringBeanInjection.setAge(20);
//       nonSpringBeanInjection.setSalary(1000);
//       nonSpringBeanInjection.setDesignation("associate");
//       return nonSpringBeanInjection;
//    }
    
}
