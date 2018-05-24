package com.perot.training.daythree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ListenerImpl implements ApplicationListener {

    private static final Log logger = LogFactory.getLog(ListenerImpl.class);
    
    public void onApplicationEvent(ApplicationEvent arg0) {
        if (arg0 != null) {
            logger.info("event received " + arg0.getClass().getName());
        }
        if (arg0 instanceof ExampleApplicationEvent){
            ExampleApplicationEvent e = (ExampleApplicationEvent) arg0;
            logger.info(e.getSource().getClass()+ " message - " +e.getMessage());
        }
    }

}
