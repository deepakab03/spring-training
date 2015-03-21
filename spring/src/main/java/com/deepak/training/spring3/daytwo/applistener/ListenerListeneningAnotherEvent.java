package com.deepak.training.spring3.daytwo.applistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class ListenerListeneningAnotherEvent implements ApplicationListener<AnotherApplicationEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ListenerListeneningAnotherEvent.class);
    
    public void onApplicationEvent(AnotherApplicationEvent e) {
            logger.info("!!--Got Event {} from {}, msg: {}", e.getClass().getSimpleName(), e.getSource().getClass().getSimpleName(), e.getMessage());
    }
}
