package com.deepak.training.spring3.daytwo.methodinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepak.training.spring3.daytwo.SomeService;

public class SimpleCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SimpleCommand.class);
    
    private Object state;

    private SomeService someService;
    
    @Override
    public void setState(Object commandState) {
        this.state = commandState;
    }

    @Override
    public Object execute() {
        logger.info("Executing simple command with state: {}", state);
        return state.toString() + someService.fetchValue();
    }

    public void setDependency(SomeService someService) {
        this.someService= someService;
    }

}
