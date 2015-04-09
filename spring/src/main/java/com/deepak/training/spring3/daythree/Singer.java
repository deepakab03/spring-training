package com.deepak.training.spring3.daythree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singer {
    private static final Logger logger = LoggerFactory.getLogger(Singer.class);

    public void perform() {
        logger.info("Singer is singing");
    }
}
