
package com.deepak.training.spring3.dayone;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.DayOneComponentScanConfig;

@ContextConfiguration(classes=DayOneComponentScanConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldComponentScanIT {

    @Autowired private AnnotatedHelloWorld annotatedHelloWorld;
    
    @Test public void
    systemShouldPrintHelloToConsole() throws IOException {
        annotatedHelloWorld.hello();
        
        assertThat(annotatedHelloWorld.getAnnotatedHelloWorld2(), is(notNullValue()));
    }
    
}
