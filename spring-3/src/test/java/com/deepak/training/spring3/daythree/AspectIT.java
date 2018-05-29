package com.deepak.training.spring3.daythree;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daythree.DayThreeConfig;
import com.deepak.training.spring3.exception.PerformanceException;

@ContextConfiguration(classes=DayThreeConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AspectIT {

    @Rule public StandardOutputStreamLog outLog = new StandardOutputStreamLog();
    
    @Autowired private Performer instrumentalist;
    @Autowired private Artist actor;
    @Autowired private Performer dancer;
    
    @Autowired private Singer singer;
    
    @Before public void beforeEveryTest() {
        outLog.clear();
        instrumentalist.flagThrowEx(false);
    }
    
    @Test public void
    whenPerform_givenInstrumentalistPerformsWell_shouldPerformWithAudience() throws PerformanceException {
        instrumentalist.perform();
        
        assertThat(outLog.getLog(), containsString("Audience is Taking seats"));
        assertThat(outLog.getLog(), containsString("Audience Turning of cells"));
        assertThat(outLog.getLog(), containsString("Performer Playing twinkle twinkle"));
        assertThat(outLog.getLog(), containsString("Audience is appalauding"));
    }
    
    @Test public void
    whenPerform_givenInstrumentalistPerformanceHasAProblem_audienceShouldDemandingRefund() throws PerformanceException {
        instrumentalist.flagThrowEx(true);
        
        instrumentalist.perform();
        
        assertThat(outLog.getLog(), containsString("Audience Turning of cells"));
        assertThat(outLog.getLog(), containsString("Performer Playing twinkle twinkle"));
        assertThat(outLog.getLog(), not(containsString("Audience is appalauding")));
        assertThat(outLog.getLog(), containsString("Boo!"));
    }
    
    //similar method with different name doesn't get adviced.. how to make both get adviced?
    @Test public void
    whenPerforms_givenActorPerforms_shouldNotHaveAnyAudienceInteraction() throws PerformanceException {
        actor.performs();
        
        assertThat(outLog.getLog(), not(containsString("Audience Turning of cells")));
        assertThat(outLog.getLog(), not(containsString("Performer Playing twinkle twinkle")));
        assertThat(outLog.getLog(), not(containsString("Audience is appalauding")));
        assertThat(outLog.getLog(), containsString("Actor is acting"));
    }
    
    //- is the performer an instance of Instrumentalist?
    //- will another Performer say Dancer also have the aspect applied to it?
    //- if yes how will you restrict the aspect to be only applicable to Dancer?
    //- if we make another non Performer implementing class, say Cleaner having a perform() method will that be advised?
    //- will that singer also be an instance of Singer?
    //- what is the use of proxyTargetClass?
    
    
    @Test public void
    testThatinjectedInstanceIsNotAnInstanceOfInstrumentatilist() throws PerformanceException {
        assertThat(instrumentalist, not(instanceOf(Instrumentalist.class)));
    }
    
//    
//    @Test public void
//    whenPerform_givenDancer_shouldPerformWithAudience() throws PerformanceException {
//        dancer.perform();
//
//        assertThat(outLog.getLog(), containsString("Audience is Taking seats"));
//        assertThat(outLog.getLog(), containsString("Audience Turning of cells"));
//        assertThat(outLog.getLog(), containsString("Dancer dancing"));
//        assertThat(outLog.getLog(), containsString("Audience is appalauding"));
//    }
//    
//    @Test public void
//    whenPerform_givenSingerPerforms_shouldPerformWithAudience() throws PerformanceException {
//        singer.perform();
//        
//        assertThat(outLog.getLog(), containsString("Audience is Taking seats"));
//        assertThat(outLog.getLog(), containsString("Audience Turning of cells"));
//        assertThat(outLog.getLog(), containsString("Singer is singing"));
//        assertThat(outLog.getLog(), containsString("Audience is appalauding"));
//    }
//    
//    @Test public void
//    testThatinjectedInstanceIsNotAnInstanceOfSinger() throws PerformanceException {
//        assertThat(singer, is(instanceOf(Singer.class)));
//        
//    }
}
