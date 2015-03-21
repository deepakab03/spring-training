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

@ContextConfiguration(locations="/spring/context-spring-core.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldSpringConfigIT {

	@Autowired private HelloWorld helloWorld;
	
	@Test public void
	systemShouldPrintHelloToConsole() throws IOException {
		helloWorld.hello();
		
		assertThat(helloWorld.getHelloWorld2(), is(notNullValue()));
	}
	
}
