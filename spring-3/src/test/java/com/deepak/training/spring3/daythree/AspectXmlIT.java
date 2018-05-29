package com.deepak.training.spring3.daythree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.exception.PerformanceException;

@ContextConfiguration(locations="classpath:spring/aspect.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AspectXmlIT {

    @Autowired private Performer performer;
    
    @Test public void
    aspectEg() throws PerformanceException {
        performer.perform();
    }
}
