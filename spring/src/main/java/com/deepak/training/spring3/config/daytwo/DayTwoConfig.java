package com.deepak.training.spring3.config.daytwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.deepak.training.spring3.config.dayone.DayOneConfig;
import com.deepak.training.spring3.dayone.HelloWorld2;
import com.deepak.training.spring3.daytwo.AnotherService;
import com.deepak.training.spring3.daytwo.BeanLifeCycleEg;
import com.deepak.training.spring3.daytwo.InitDestroyEg;
import com.deepak.training.spring3.daytwo.InitDestroyEg2;
import com.deepak.training.spring3.daytwo.InitDestroyEg3;
import com.deepak.training.spring3.daytwo.SomeService;
import com.deepak.training.spring3.daytwo.ThirdService;
import com.deepak.training.spring3.daytwo.applistener.ListenerListeneningAnotherEvent;
import com.deepak.training.spring3.daytwo.applistener.TaxCalculator;

@Configuration
@Lazy
@Import(DayOneConfig.class)
public class DayTwoConfig {
    private static final Logger logger = LoggerFactory.getLogger(DayTwoConfig.class);
    
    @Autowired private DayOneConfig dayOneConfig;
    
    @Bean
    public SomeService someService() {
       return new SomeService();
    }
    
    /**
     * Init destroy methods
     * @return
     */
    //preferred way
	@Bean(initMethod="init", destroyMethod="destroy")
	public InitDestroyEg initDestroyEg() {
	    InitDestroyEg id = new InitDestroyEg();
		id.setClasspathFileName(dayOneConfig.classpathFileName());
		dayOneConfig.classpathFileName();
        return id;
	}
	
	@Bean
    public InitDestroyEg2 initDestroyEg2ThroughBeanPostProcessors() {
	    InitDestroyEg2 id = new InitDestroyEg2();
        id.setClasspathFileName(dayOneConfig.classpathFileName());
        return id;
    }
	
	@Bean
    public InitDestroyEg3 initDestroyEg2ThroughJavaxAnnotation() {
	    InitDestroyEg3 id = new InitDestroyEg3();
        id.setClasspathFileName(dayOneConfig.classpathFileName());
        return id;
    }
	
	/*
	 * bean lifecycle, bean post processors
	 */
	@Bean
    public BeanLifeCycleEg beanLifeCycleEg() {
	    BeanLifeCycleEg id = new BeanLifeCycleEg();
	    id.setHelloWorld2(dayOneConfig.helloWorld2());
        return id;
    }
	
	/*
	 * Alias, names of beans and lazy initialization at a bean / config level.
	 * @return
	 */
    @Bean(name="hww")
//    @Lazy
    public HelloWorld2 helloWorld2() {
        logger.info("creating hello world2 in day2Config");
        return new HelloWorld2("commo sava");
    }
    
    /*
     * Bean scopes
     */
    @Bean
    @Scope(value="prototype")
    public AnotherService anotherService() {
        return new AnotherService(someService());
    }
    
    @Bean
    public ThirdService thirdServiceA() {
        return new ThirdService(someService());
    }
    
    @Bean
    public ThirdService thirdServiceB() {
        return new ThirdService(someService());
    }
    
    /*
     * Application Listeners and events
     */
    @Bean
//    @Scope(value="prototype")?
    public TaxCalculator listenerImpl() {
        return new TaxCalculator();
    }
    
    @Bean
    public ListenerListeneningAnotherEvent listeneningAnotherEvent() {
        return new ListenerListeneningAnotherEvent();
    }
    
    /*
     * Internationalization with messageSource's
     */
    //changing bean name, changing base property name, adding another base property file?
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("errorMsg");
//        Adding anotherBase name having the same keys?
//        source.setBasenames("labelDisplay");
        
        return source;
    }
}
