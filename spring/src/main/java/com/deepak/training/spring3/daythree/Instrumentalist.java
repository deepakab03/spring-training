package com.deepak.training.spring3.daythree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deepak.training.spring3.exception.PerformanceException;

//how would the intrumentalist --> audience functionality be traditionally implemented?
public class Instrumentalist implements Performer {
    private static final Log logger = LogFactory.getLog(Instrumentalist.class);
    private String song;

    public void perform() throws PerformanceException {
            logger.info("Performer Playing " + song);
//            if (true) throw new PerformanceException("test exception");
    }

    public void setSong(String song) {
        this.song = song;
    }

}
