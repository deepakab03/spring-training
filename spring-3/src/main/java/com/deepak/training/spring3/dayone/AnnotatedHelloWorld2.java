package com.deepak.training.spring3.dayone;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedHelloWorld2 {
    private static final Logger logger = LoggerFactory.getLogger(AnnotatedHelloWorld2.class);

    private String message = "Namaskar";

    public void sayHelloAgain() {
        logger.info("Again Saying hello: {}", message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
