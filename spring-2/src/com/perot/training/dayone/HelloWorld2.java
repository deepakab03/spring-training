package com.perot.training.dayone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld2 {
    private static final Log logger = LogFactory.getLog(HelloWorld2.class);

	private HelloWorld helloWorld;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		logger.info("In hello world 2 calling helloWorld msg2 " + helloWorld.getMessage2());
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
}
