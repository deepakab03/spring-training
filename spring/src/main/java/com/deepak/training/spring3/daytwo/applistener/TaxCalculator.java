package com.deepak.training.spring3.daytwo.applistener;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class TaxCalculator implements ApplicationListener<ExampleApplicationEvent> {
//    ApplicationListener<ApplicationEvent ?
    private static final Logger logger = LoggerFactory.getLogger(TaxCalculator.class);
    
    private static final AtomicInteger numEventsProcesed = new AtomicInteger();
    
    public void onApplicationEvent(ExampleApplicationEvent e) {
//        if (arg0 != null) {
//            logger.info("event received " + arg0.getClass().getName());
//        }
//        if (arg0 instanceof ExampleApplicationEvent){
//            ExampleApplicationEvent e = (ExampleApplicationEvent) arg0;
            logger.info("Got Event {} from {}, msg: {}", e.getClass().getSimpleName(), e.getSource().getClass().getSimpleName(), e.getMessage());
            numEventsProcesed.incrementAndGet();
//        }
    }
    
    public static void resetNumEventsProcessed() {
        numEventsProcesed.set(0);
    }
    
    public static int numEventsProcessed() {
        return numEventsProcesed.get();
    }

}
