/**
 * 
 */
package com.perot.training.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.PatternLayout;

/**
 * @author abrahade
 *
 */
public class Utils {

    public static void initLog4j() {
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("[%t:%c{2}:%L][%d{HH:mm:ss,SSS}] %p %m%n")));
        LogManager.getRootLogger().setLevel(Level.INFO);
    }

}
