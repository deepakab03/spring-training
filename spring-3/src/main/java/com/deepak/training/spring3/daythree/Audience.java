package com.deepak.training.spring3.daythree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Audience {
    private static final Log logger = LogFactory.getLog(Audience.class);
    
    public void takeSeats() {
        logger.info("Audience Taking seats");
    }
    
    public void turnOffCellPhones() {
        logger.info("Audience Turning of cells");
    }
    public void applaud() {
        logger.info("Audience applauding");
    }
    public void demandRefund() {
        logger.info("Audience want money back");
    }
}
