package com.deepak.training.spring3.dayone;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.dayone.config.DayOneConfig;

@ContextConfiguration(classes=DayOneConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldIT {

	@Autowired private HelloWorld helloWorld;
	
	@Test public void
	systemShouldPrintHelloToConsole() throws IOException {
		helloWorld.hello();
	}
	
}
