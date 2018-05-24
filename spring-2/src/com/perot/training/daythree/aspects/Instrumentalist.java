package com.perot.training.daythree.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Instrumentalist implements Performer {
    private static final Log logger = LogFactory.getLog(Instrumentalist.class);

    public void perform() throws PerformanceException {
            logger.info("Performer Playing " + song);
//            if (true) throw new PerformanceException("test exception");
    }

    private String song;

    public void setSong(String song) {
        this.song = song;
    }

}
