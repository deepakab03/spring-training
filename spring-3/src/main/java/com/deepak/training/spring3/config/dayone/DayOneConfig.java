package com.deepak.training.spring3.config.dayone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.deepak.training.spring3.dayone.HelloWorld;
import com.deepak.training.spring3.dayone.HelloWorld2;

@Configuration
@Lazy
public class DayOneConfig {
    private static final Logger logger = LoggerFactory.getLogger(DayOneConfig.class);
    
	@Bean
	public HelloWorld helloWorld() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setClasspathFileName(classpathFileName());
		helloWorld.setHelloWorld2(helloWorld2());
        return helloWorld;
	}
	
	//what happens if we comment the @Bean annotation?
	@Bean
	public String classpathFileName() {
	    logger.info("Creating the classpath file name bean");
	    return "hw.txt";
	}
	
    @Bean
    public HelloWorld2 helloWorld2() {
        logger.info("creating hello world2");
        return new HelloWorld2();
    }
}
