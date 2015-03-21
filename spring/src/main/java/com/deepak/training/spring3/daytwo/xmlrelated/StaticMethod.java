package com.deepak.training.spring3.daytwo.xmlrelated;


public class StaticMethod {
	
	public static Child getChild() {
		Child child = new Child();
		child.setName("Pavan");
		return child;
	}
}
