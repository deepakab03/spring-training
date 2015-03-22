package com.deepak.training.spring3.daytwo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.DayTwoConfig;

@ContextConfiguration(classes=DayTwoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class InitDestroyIT {

    @Autowired private InitDestroyEg initDestroyEg;
    @Autowired private InitDestroyEg2 initDestroyEg2;
    @Autowired private InitDestroyEg3 initDestroyEg3;
    
    //how is destroy called?
    @Test public void
    initDestroy() throws IOException {
        initDestroyEg.hello();
        initDestroyEg2.hello();
        initDestroyEg3.hello();
    }
}
