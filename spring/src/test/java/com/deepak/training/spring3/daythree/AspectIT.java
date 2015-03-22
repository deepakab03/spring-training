package com.deepak.training.spring3.daythree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daythree.DayThreeConfig;
import com.deepak.training.spring3.exception.PerformanceException;

@ContextConfiguration(classes=DayThreeConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AspectIT {

    @Autowired private Performer performer;
    
    @Test public void
    aspectEg() throws PerformanceException {
        performer.perform();
    }
}
