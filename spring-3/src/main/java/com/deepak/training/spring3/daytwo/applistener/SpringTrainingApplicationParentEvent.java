package com.deepak.training.spring3.daytwo.applistener;

import org.springframework.context.ApplicationEvent;

public class SpringTrainingApplicationParentEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private String message;

    public SpringTrainingApplicationParentEvent(Object source) {
        super(source);
    }
    
    public SpringTrainingApplicationParentEvent(Object source, String msg) {
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
