package com.deepak.training.spring3.config.daytwo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.deepak.training.spring3.config.dayone.DayOneConfig;
import com.deepak.training.spring3.daytwo.SomeService;
import com.deepak.training.spring3.daytwo.methodinjection.AsyncCommand;
import com.deepak.training.spring3.daytwo.methodinjection.SimpleCommand;

@Configuration
@ComponentScan(basePackages="com.deepak.training.spring3.daytwo")
@Import(DayOneConfig.class)
public class DayTwoComponentScanConfig {
    
    @Bean
    public SomeService someService() {
       return new SomeService();
    }
    
    //only works through component scan
//    @Bean 
//    public CommandManagerAnnotated commandManager() {
//        CommandManagerAnnotated commandManager = new CommandManagerAnnotated();
//        return commandManager;
//    }
    
    @Bean @Scope(value="prototype")
    public SimpleCommand simpleCommand() {
        SimpleCommand command = new SimpleCommand();
        command.setDependency(someService());
        
        return command;
    }
    
    @Bean @Scope(value="prototype")
    public AsyncCommand asyncCommand() {
        AsyncCommand command = new AsyncCommand();
        command.setSomeService(someService());
        
        return command;
    }
}
