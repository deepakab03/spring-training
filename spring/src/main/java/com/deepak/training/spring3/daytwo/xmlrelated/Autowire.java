/**
 * 
 */
package com.deepak.training.spring3.daytwo.xmlrelated;

import com.deepak.training.spring3.dayone.HelloWorld2;
import com.deepak.training.spring3.daytwo.methodinjection.AsyncCommand;

/**
 * @author user
 * 
 */
public class Autowire {
	//instantiated for compound naming
	private HelloWorld2 helloWorld = new HelloWorld2();
	private AsyncCommand command;

	public Autowire() {
		super();
	}

	public Autowire(HelloWorld2 helloWorld, AsyncCommand command) {
		this.helloWorld = helloWorld;
		this.command = command;
	}

	public HelloWorld2 getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld2 helloWorld) {
		this.helloWorld = helloWorld;
	}

	public AsyncCommand getCommand() {
		return command;
	}

	public void setCommand(AsyncCommand command) {
		this.command = command;
	}

}
