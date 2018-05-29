package com.deepak.training.spring3.dayone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld2 {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld2.class);

    private String message = "Namaskar";

    public HelloWorld2() {
    }

    public HelloWorld2(String message) {
        this.message = message;
    }

    public String sayHelloAgain() {
        logger.info("Again Saying hello: {}", message);
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
