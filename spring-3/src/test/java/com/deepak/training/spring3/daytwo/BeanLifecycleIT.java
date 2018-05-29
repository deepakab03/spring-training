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
public class BeanLifecycleIT {

    @Autowired private BeanLifeCycleEg beanLifeCycleEg;
    
    //how is destroy called?
    @Test public void
    initDestroy() throws IOException {
        beanLifeCycleEg.doSomething("someService");
    }
}
