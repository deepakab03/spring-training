/**
 * 
 */
package com.perot.training.daythree;

import com.perot.training.dayone.HelloWorld;
import com.perot.training.daytwo.AsyncCommand;

/**
 * @author user
 * 
 */
public class Autowire {
	//instantiated for compound naming
	private HelloWorld helloWorld ;//= new HelloWorld();
	private AsyncCommand command;

	public Autowire() {
		super();
	}

	public Autowire(HelloWorld helloWorld, AsyncCommand command) {
		this.helloWorld = helloWorld;
		this.command = command;
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public AsyncCommand getCommand() {
		return command;
	}

	public void setCommand(AsyncCommand command) {
		this.command = command;
	}

}
