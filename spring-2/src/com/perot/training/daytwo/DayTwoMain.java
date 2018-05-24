package com.perot.training.daytwo;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perot.training.dayone.HelloWorld;
import com.perot.training.daythree.aspects.PerformanceException;
import com.perot.training.util.Utils;

public class DayTwoMain {
    private static final Log logger = LogFactory.getLog(DayTwoMain.class);
    
	/**
	 * @param args
	 * @throws IOException 
	 * @throws PerformanceException 
	 */
	public static void main(String[] args) throws IOException {
	    Utils.initLog4j();
	    dayTwo();
	}
	
	static void dayTwo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"com/perot/training/daytwo/daytwo.xml");
        /*
         * alias tag and name attribute
         */
        logger.info(((HelloWorld)ctx.getBean("app.HiWorld")).getMessage());
        logger.info(((HelloWorld)ctx.getBean("hw")).getMessage());
        /*
         * ?
         */
        logger.info(((Child)ctx.getBean("childBean")).getName());
        /*
         * Other bean creation methods
         */
        logger.info(((Child)ctx.getBean("staticMethChild")).getName());
        logger.info(ctx.getBean("collectionCreater"));
        
        /* mapping collections */
//        List<String> nameList = ((Child)ctx.getBean("childBean")).getChildList();
//        for (String string : nameList) {
//			logger.info("Name ->" + string);
//		}
//        Map<String,Object> map1 = ((Child)ctx.getBean("childBean")).getMap();
//        logger.info("map ->"+map1);
        
        
//        Outer outer = (Outer) ctx.getBean("outer");
//        logger.info("outer target child -> " + outer.getTarget());
        
        	/*
        	 * Getter injection
        	 */
//        CommandManager man = (CommandManager) ctx.getBean("commandManager");
//        Object value = man.process("some state");
//        logger.info("Command processing complete " + value);
//        
//         value = man.process("b state");
//        logger.info("Command processing complete " + value);
//        
//        value = man.process("c state");
//        logger.info("Command processing complete " + value);
        
        /*
         * Method replacement
         */
//        MyValueCalculator calc = (MyValueCalculator) ctx.getBean("myValueCalculator");
//        String val = calc.computeValue("some text");
//        logger.info("My val calc - " + val);
        
        
        

	}


}
