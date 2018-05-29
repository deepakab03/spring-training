package com.deepak.training.spring3.daythree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepak.training.spring3.exception.PerformanceException;

/**
 * @author abrahd2
 *
 */
public class Dancer implements Performer {
    private static final Logger logger = LoggerFactory.getLogger(Dancer.class);

    /* (non-Javadoc)
     * @see com.deepak.training.spring3.daythree.Performer#perform()
     */
    @Override
    public void perform() throws PerformanceException {
        logger.info("Dancer dancing");
    }

    @Override
    public void flagThrowEx(boolean throwEx) {
       throw new UnsupportedOperationException();
    }

}
