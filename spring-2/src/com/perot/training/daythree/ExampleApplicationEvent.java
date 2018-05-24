package com.perot.training.daythree;

import org.springframework.context.ApplicationEvent;

public class ExampleApplicationEvent extends ApplicationEvent {

    private String message;
 
    public ExampleApplicationEvent(Object source, String msg) {
        super(source);
        message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
