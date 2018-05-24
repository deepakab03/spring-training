package com.perot.training.dayfive;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perot.training.dayfour.DayFourDao;
import com.perot.training.dayfour.tran.TransactionService;
import com.perot.training.daythree.aspects.PerformanceException;
import com.perot.training.util.Utils;

public class DayFiveMain {
    private static final Log   logger       = LogFactory.getLog(DayFiveMain.class);

    public static final String SERVICE_NAME = "dayFiveService";

    private PersonName         personName;
    private PersonName2        personName2;

    /**
     * Add dom4j, both sl4j jars, j2ee/jta.jar,javaassis/javaAssist.jar
     * 
     * @param args
     * @throws IOException
     * @throws PerformanceException
     * @throws PerformanceException
     */
    public static void main(String[] args) throws IOException, PerformanceException {
        Utils.initLog4j();
        dayFive();
    }

    static void dayFive() throws IOException, PerformanceException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/perot/training/dayfive/dayfive.xml");

        // DayFourDao dao = (DayFourDao) ctx.getBean("dayFiveDao");
        // dao.fetchAll();

        /*
         * property editors
         */
        DayFiveMain dayFiveMain = (DayFiveMain) ctx.getBean("dayFiveMain");
        logger.info("Person name: " + dayFiveMain.getPersonName());
        logger.info("Person name2: " + dayFiveMain.getPersonName2());

    }

    public PersonName2 getPersonName2() {
        return personName2;
    }

    public void setPersonName2(PersonName2 personName2) {
        this.personName2 = personName2;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

}
