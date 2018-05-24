package com.perot.training.daytwo;

public interface Command {

	public void setState(Object commandState);
		

	public Object execute();

}
