package com.deepak.training.spring3.daytwo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deepak.training.spring3.dayone.HelloWorld;
import com.deepak.training.spring3.daytwo.config.DayTwoConfig;
import com.deepak.training.spring3.daytwo.methodinjection.CommandManager;
import com.deepak.training.spring3.daytwo.xmlrelated.Autowire;
import com.deepak.training.spring3.daytwo.xmlrelated.Child;
import com.deepak.training.spring3.daytwo.xmlrelated.MyValueCalculator;
import com.deepak.training.spring3.daytwo.xmlrelated.Outer;

public class DayTwo {
    private static final Logger logger = LoggerFactory.getLogger(DayTwo.class);
	
	public static void dayTwo() throws BeansException, IOException {
	    ApplicationContext ctx = new AnnotationConfigApplicationContext(DayTwoConfig.class); 
	    
//	    initDestroyFromMain(ctx);
	    
	    xmlRelated();	    
	}

    static void initDestroyFromMain(ApplicationContext ctx) throws IOException {
//        ((AbstractApplicationContext) ctx).registerShutdownHook();
	    InitDestroyEg initDestroyEg = ctx.getBean(InitDestroyEg.class);
	    initDestroyEg.hello();
    }

    private static void xmlRelated() throws IOException {
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
"spring/daytwo.xml")) {
            /*
             * autowire in xml
             */
            Autowire autoWireEg = (Autowire) ctx.getBean("autowireEg");
            logger.info("autoWire hello: {}", autoWireEg.getHelloWorld()
                    .getMessage());
            /*
             * alias tag and name attribute
             */
            logger.info(((HelloWorld) ctx.getBean("app.HiWorld")).getMessage());
            logger.info(((HelloWorld) ctx.getBean("hw")).getMessage());
            /*
             * outer and inner beans
             */
            Outer outer = (Outer) ctx.getBean("outer");
            logger.info("outer target child -> " + outer.getTarget()
                    .getName());
            /*
             * Other bean creation methods
             */
            logger.info(((Child) ctx.getBean("staticMethChild")).getName());
            logger.info(ctx.getBean("collectionCreater")
                    .toString());

            /* mapping collections */
            List<String> nameList = ((Child) ctx.getBean("childBean")).getChildList();
            for (String string : nameList) {
                logger.info("Name ->" + string);
            }
            Map<String, Object> map1 = ((Child) ctx.getBean("childBean")).getMap();
            logger.info("map ->" + map1);

            /*
             * Getter injection
             */
            CommandManager man = (CommandManager) ctx.getBean("commandManager");
            Object value = man.process("some state");
            logger.info("Command processing complete " + value);

            value = man.process("b state");
            logger.info("Command processing complete " + value);

            value = man.process("c state");
            logger.info("Command processing complete " + value);

            /*
             * Method replacement (only through xml)
             */
            MyValueCalculator calc = (MyValueCalculator) ctx.getBean("myValueCalculator");
            String val = calc.computeValue("some text");
            logger.info("My val calc - " + val);

            /*
             * compound name
             */
            logger.info(((Autowire) ctx.getBean("compoundNaming")).getHelloWorld()
                    .getMessage());
        }
    }


}
