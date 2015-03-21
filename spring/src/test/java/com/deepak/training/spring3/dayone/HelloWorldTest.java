package com.deepak.training.spring3.dayone;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

    private HelloWorld helloWorld = new HelloWorld();
    
    @Before
    public void beforeAnyTest() {
        helloWorld.setHelloWorld2(new HelloWorld2());
        
    }
    
	@Test public void
	whenHello_givenDataInFile_shouldReturnCorrectContents() throws IOException {
		//given
		helloWorld.setClasspathFileName("hw.txt");
		
		//when
		String contents = helloWorld.hello();
		
		//then
		assertThat(contents, equalTo("Hello!"));
	}
}
