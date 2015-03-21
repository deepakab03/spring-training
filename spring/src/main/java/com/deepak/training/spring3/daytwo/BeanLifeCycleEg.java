package com.deepak.training.spring3.daytwo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.deepak.training.spring3.dayone.HelloWorld2;

public class BeanLifeCycleEg implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(BeanLifeCycleEg.class);
    
    private ApplicationContext ctx;

    private HelloWorld2 helloWorld2;
    
    public BeanLifeCycleEg() {
        logger.info("in constructor ofBeanLifeCycleEg ");
    }
    
    @PostConstruct
    public void init() {
        logger.info("In init");
    }
    
    public void doSomething(String beanNameString ) {
        logger.info("Bean: {}", ctx.getBean(beanNameString));
    }
    
    @PreDestroy
    public void destroy() {
        logger.info("In destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("setting ctx in BeanLifeCycleEg");
        this.ctx = applicationContext;
    }
    
    public HelloWorld2 getHelloWorld2() {
        return helloWorld2;
    }

    public void setHelloWorld2(HelloWorld2 helloWorld2) {
        this.helloWorld2 = helloWorld2;
    }
}
