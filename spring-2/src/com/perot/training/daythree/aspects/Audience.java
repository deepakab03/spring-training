package com.perot.training.daythree.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Audience {
    private static final Log logger = LogFactory.getLog(Audience.class);
    
    public void takeSeats() {
        logger.info("Aud Taking seats");
    }
    
    public void turnOffCellPhones() {
        logger.info("Aud Turning of cells");
    }
    public void applaud() {
        logger.info("Aud appalauding");
    }
    public void demandRefund() {
        logger.info("Aud want money back");
    }
}
