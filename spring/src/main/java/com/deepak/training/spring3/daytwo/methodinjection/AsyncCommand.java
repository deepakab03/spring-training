package com.deepak.training.spring3.daytwo.methodinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepak.training.spring3.daytwo.SomeService;
import com.deepak.training.spring3.daytwo.xmlrelated.Child;

public class AsyncCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AsyncCommand.class);
    
    private Object state;
    private double random = Math.random();
    private SomeService someService;
    
	public Object execute() {
		String execution = state + " " + random + ", " + someService.fetchValue();
		logger.info("Async cmd exec: {}", execution);
        return execution;
	}

	public void setState(Object commandState) {
		state = commandState;
	}
	
	public void setSomeService(SomeService someService) {
        this.someService= someService;
    }

}
