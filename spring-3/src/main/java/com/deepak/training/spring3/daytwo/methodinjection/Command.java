package com.deepak.training.spring3.daytwo.methodinjection;

public interface Command {

	public void setState(Object commandState);
		

	public Object execute();

}
