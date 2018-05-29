package com.deepak.training.spring3.daytwo.methodinjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//only works with component scan
@Component
public class CommandManagerAnnotated implements ApplicationContextAware {
    
    private ApplicationContext ctx;
    
    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }
    
    //instead of using ctx.getBean and get tied to spring.. doesn't make sense much for annotations
    @Lookup(value="asyncCommand")
    protected Command createCommand() {
//        return (Command) ctx.getBean("asyncCommand");
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

}
