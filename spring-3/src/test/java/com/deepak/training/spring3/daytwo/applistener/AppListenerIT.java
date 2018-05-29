package com.deepak.training.spring3.daytwo.applistener;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.DayTwoConfig;

@ContextConfiguration(classes=DayTwoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppListenerIT {

    @Autowired private ApplicationContext ctx;
    

//    @Autowired private TaxCalculator taxCalculator1;
//    @Autowired private TaxCalculator taxCalculator2;
    
    @Before public void beforeEveryTest() {
        TaxCalculator.resetNumEventsProcessed();
    }
    
    @Test public void
    shouldPublishAndCaptureApplicationEventProperly() {
         ctx.publishEvent(new ExampleApplicationEvent(this, "event fired from test"));
         
         //create two listeners for the same event?
         //then no one is listening to AnotherApplicationEvent event, 
         //how to make one listener listen to the two events
//         ctx.publishEvent(new AnotherApplicationEvent(this));
         
         //prototype listeners?
//         assertThat(taxCalculator1, is(not(equalTo(taxCalculator2))));
         assertThat(TaxCalculator.numEventsProcessed(), is(1));
    }
}
