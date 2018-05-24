package com.perot.training.daytwo;

public class AsyncCommand implements Command {
	Object state;
	double random = Math.random();
	public Object execute() {
		return state + " " + random;
		
	}

	public void setState(Object commandState) {
		state = commandState;
	}

}
