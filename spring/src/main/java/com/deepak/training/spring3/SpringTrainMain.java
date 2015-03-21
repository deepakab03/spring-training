package com.deepak.training.spring3;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepak.training.spring3.dayone.HelloWorld;
import com.deepak.training.spring3.dayone.config.DayOneConfig;
import com.deepak.training.spring3.daytwo.DayTwo;

public class SpringTrainMain {
    private static final Logger logger = LoggerFactory.getLogger(SpringTrainMain.class);
    
    public static void main(String[] args) throws IOException {
//        dayOne();
        dayTwo(args);
    }

    @SuppressWarnings("resource")
    static void dayOne() throws IOException {
        ApplicationContext ctx= new AnnotationConfigApplicationContext(DayOneConfig.class);
                //new ClassPathXmlApplicationContext("/spring/context-spring-core.xml");
        
        HelloWorld hw = (HelloWorld) ctx.getBean("helloWorld");
        
        hw.hello();
        
    }
    
    static void dayTwo(String[] args) throws IOException {
//        addTestShutDownHook();
        DayTwo.dayTwo();
    }


    static void addTestShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            
            @Override
            public void run() {
                logger.info("In shutdown hook");
            }
        }));
    }

}
