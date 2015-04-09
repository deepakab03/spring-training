package com.deepak.training.spring3.daythree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author abrahd2
 *
 */
public class ActorArtist implements Artist {
    private static final Logger logger = LoggerFactory.getLogger(ActorArtist.class);
    
    @Override
    public void performs() {
        logger.info("Actor is acting");
    }

}
