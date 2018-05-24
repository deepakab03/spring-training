package com.perot.training.dayone;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld {
    private static final Log logger = LogFactory.getLog(HelloWorld.class);
	
	private String message;
	private HelloWorld2 hello2;
	private String message2;
	

	public HelloWorld() {
	}

	public HelloWorld(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
		logger.info(hello2.getMsg());
	}
	
	public HelloWorld2 getHello2() {
		return hello2;
	}

	public void setHello2(HelloWorld2 hello2) {
		this.hello2 = hello2;
	}

	
	public List<String> createInstance() {
		return Collections.singletonList("Any object");
	}
}
