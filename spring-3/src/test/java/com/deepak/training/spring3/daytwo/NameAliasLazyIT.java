package com.deepak.training.spring3.daytwo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.DayTwoConfig;
import com.deepak.training.spring3.dayone.HelloWorld2;

@ContextConfiguration(classes=DayTwoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class NameAliasLazyIT {

    @Autowired private HelloWorld2 helloWorld2;
    @Autowired private HelloWorld2 hww;
    @Autowired private HelloWorld2 hww2;
    
//    @Autowired private HelloWorld2 helloWorld22;?
    
    @Test public void
    nameAliasTest() throws IOException {
        String msg = helloWorld2.sayHelloAgain();
        assertThat(msg, is("Namaskar"));
        
        msg = hww.sayHelloAgain();
        assertThat(msg, is("commo sava"));
        
        msg = hww2.sayHelloAgain();
        assertThat(msg, is("commo sava"));
        
    }
}
