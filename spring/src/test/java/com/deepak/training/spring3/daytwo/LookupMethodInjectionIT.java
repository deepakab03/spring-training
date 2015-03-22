package com.deepak.training.spring3.daytwo;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.DayTwoComponentScanConfig;
import com.deepak.training.spring3.daytwo.methodinjection.CommandManagerAnnotated;

@ContextConfiguration(classes=DayTwoComponentScanConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LookupMethodInjectionIT {

    @Autowired private CommandManagerAnnotated commandManagerAnnotated;
    
    @Test public void
    testExecutionForDifferentCommands() {
        commandManagerAnnotated.process("someState");
        String returnString = (String) commandManagerAnnotated.process("anotherState");
        
        assertThat(returnString, Matchers.containsString("anotherState"));
    }
}
