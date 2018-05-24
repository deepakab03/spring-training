package com.perot.training.daythree;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.perot.training.dayone.HelloWorld;
import com.perot.training.daythree.aspects.PerformanceException;
import com.perot.training.daythree.aspects.Performer;
import com.perot.training.daytwo.Child;
import com.perot.training.daytwo.Command;
import com.perot.training.util.Utils;

public class DayThreeMain {

    /**
     * @param args
     * @throws IOException
     * @throws PerformanceException
     * @throws PerformanceException
     */
    public static void main(String[] args) throws IOException, PerformanceException {
        Utils.initLog4j();
        dayThree();
    }

    static void dayThree() throws IOException, PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/perot/training/daythree/daythree.xml");
        /*
         * compound name
         */
        // logger.info(((Autowire)ctx.getBean("compoundNaming")).getHelloWorld().getMessage());
        /*
         * Autowiring eg
         */
        // Autowire autowire = (Autowire)ctx.getBean("autoWireEg2");
        // logger.info(autowire.getHelloWorld().getMessage());

        /*
         * prototype eg
         */
        // Command c1 = (Command) ctx.getBean("command");
        // Command c2 = (Command) ctx.getBean("command");
        // if (c1 == c2) {
        // logger.info("Same");
        // } else {
        // logger.info("Not same");
        // }

        /*
         * init & destroy methods, bean name aware, app ctx aware
         */
        // ctx.getBean("initDestroyEg");//initDestroyEg
        // ((AbstractApplicationContext)ctx).registerShutdownHook();

        /*
         * parent child bean relation
         */
        // Child c = (Child) ctx.getBean("childBean");
        // Child c2 = (Child) ctx.getBean("childBean2");
        // logger.info("child 1 " + c);
        // logger.info("child 2 " + c2);

        /*
         * messageSource beans, us is default locale in India so _en_US might not work.
         */
        // logger.info("Current Locale: " + Locale.getDefault());
        // String msg = ctx.getMessage("noDetailsFound", null, "No details found", null);
        // //passing a different locale as the 3rd arg doesn't work..?
        // //Locale.setDefault(Locale.US);
        // String msg = ctx.getMessage("noDetailsFound", null, Locale.US);
        // String msg = ctx.getMessage("enterDetailsToday", new Object[] { new Date() }, "No details found",
        // Locale.UK); //passing values
        // //unknown key eg
        // String msg = ctx.getMessage("noDetailsFoundAgain", null, "No details found", Locale.UK); //using
        // default msg
        // logger.info(msg);

        /*
         * Listeners and events
         */
        // ctx.publishEvent(new ExampleApplicationEvent(new DayThreeMain(),"event fired from day 3 main"));

        /*
         * Resource implementation
         */
        // Resource r = new ClassPathResource("errormsg.properties");
        // // new FileSystemResource("path");
        // System.getProperties().load(r.getInputStream());
        // logger.info(System.getProperty("noDetailsFound"));

        /**
         * Injecting non spring beans using aspectj LTW - Add spring/dist/weaving/spring-aspects.jar to
         * classpath.
         * <ol>
         * <li>Add @Configurable on top of class decl of bean with the bean id (eg "nonSpringBean" passed in
         * brackets
         * <li>Declare the nonSpringBean abstract bean definiton in xml with required injected properties
         * <li>Add <context:spring-configured/> line to xml.
         * <li>Add the following jvmagent to your runtime invocation -> -javaagent:pathTo/aspectjweaver.jar
         * </ol
         */
//        NonSpringBeanInjection n = new NonSpringBeanInjection();
//        logger.info(n.toString());

        /*
         * Aspects
         */
         Performer i = (Performer) ctx.getBean("instrm");
         i.perform();

    }

}
