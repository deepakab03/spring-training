package com.perot.training.dayfour;

 import java.io.IOException; 
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.perot.training.dayfour.model.Pet;
import com.perot.training.dayfour.tran.TransactionService;
import com.perot.training.dayone.HelloWorld;
import com.perot.training.daythree.aspects.PerformanceException;
import com.perot.training.daythree.aspects.Performer;
import com.perot.training.util.Utils;

public class DayFourMain {
	private static final Log logger = LogFactory.getLog(DayFourMain.class);

	/**
	 * Add dom4j, both sl4j jars, j2ee/jta.jar,javaassis/javaAssist.jar
	 * @param args
	 * @throws IOException 
	 * @throws PerformanceException 
	 * @throws PerformanceException 
	 */
	public static void main(String[] args) throws IOException, PerformanceException {
//	    Utils.initLog4j();
	    dayFour();
	}
	
	static void dayFour() throws IOException, PerformanceException {
		
        /*
	     * old way of interacting with database using JDBC
	     */
	    DBManager.registerDriver();
	    JdbcDao jdao=new JdbcDao();
	    jdao.fetchAll();


//        ApplicationContext ctx = new ClassPathXmlApplicationContext(
//		"com/perot/training/dayfour/dayfour.xml");
        

//      DayFourDao dao = (DayFourDao) ctx.getBean("dayFourDao");
//      dao.fetchAll();
      
//      dao.exceptionCreation();
      
//      dao.fetchPet(new Pet("judy"));
      
      /*
       * Using an ORM tool like Hibernate - dependecies - antlr, dom4j, sl4j, j2ee-transation, hibernate jars
       */
//      HibernateDao hdao = (HibernateDao) ctx.getBean("hibernateDao");
//      Pet p = new Pet();
//      p.setOwner("Ashok");
//      hdao.deletePet(p);
      
//      hdao.deletePetUsingName(new Pet("Puffball"));
//      List<Pet>  l =hdao.fetchAllPets(); 
//      for (Pet pet : l) {
//         logger.info("pet fetched using hibernate - " + pet);
//         if (pet.getName().equals("jewel")) {
//        	 hdao.deletePet(pet);
//         }
//         
//     }
      
//      TransactionService templService=       (TransactionService) ctx.getBean("templateService");
//      templService.dojob();
      
//	     TransactionService service=       (TransactionService) ctx.getBean("service");
//      TransactionService service = (TransactionService) ctx.getBean("service2");
//	     service.dojob();
//	     service.save();

      

	}


}
