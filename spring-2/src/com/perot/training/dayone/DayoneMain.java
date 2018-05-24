package com.perot.training.dayone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perot.training.util.Utils;

public class DayoneMain {
    private static final Log logger = LogFactory.getLog(DayoneMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Utils.initLog4j();
		ApplicationContext ctx = new
		 ClassPathXmlApplicationContext("com/perot/training/dayone/dayone.xml"); 
//			new FileSystemXmlApplicationContext(
//				"D:\\Deepak\\dayone.xml");
		 
		HelloWorld hw = (HelloWorld) ctx.getBean("dayOneHelloWorld");
//		HelloWorld hw1 = (HelloWorld) ctx.getBean("dayOneHelloWorld");
//		if (hw == hw1) {
//			logger.info("same obj");
//		}
		logger.info("Message " + hw.getMessage());
	}

}
