package com.deepak.training.spring3.database;

 import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deepak.training.spring3.database.tran.TransactionService;
import com.deepak.training.spring3.exception.PerformanceException;
import com.deepak.training.spring3.model.Pet;

public class DayFourMain {
	private static final Logger logger = LoggerFactory.getLogger(DayFourMain.class);

	public static void start() throws IOException, PerformanceException {
		
        /*
	     * old way of interacting with database using JDBC
	     */
	    DBManager.registerDriver();
	    JdbcDao jdao=new JdbcDao();
	    jdao.fetchAll();


        ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"spring/database.xml");
        

      DayFourDao dao = (DayFourDao) ctx.getBean("dayFourDao");
      dao.fetchAll();
      
//      dao.exceptionCreation();
      
      dao.fetchPet(new Pet("judy"));
      
      /*
       * Using an ORM tool like Hibernate - dependecies - antlr, dom4j, sl4j, j2ee-transation, hibernate jars
       */
      HibernateDao hdao = (HibernateDao) ctx.getBean("hibernateDao");
      Pet p = new Pet();
      p.setOwner("Ashok");
//      hdao.deletePet(p); only works with a tx manager and requise anntation / xml config in place
      
      hdao.deletePetUsingName(new Pet("Puffball"));
      List<Pet>  l =hdao.fetchAllPets(); 
      for (Pet pet : l) {
         logger.info("pet fetched using hibernate - " + pet);
         if (pet.getName().equals("jewel")) {
        	 hdao.deletePet(pet);
         }
         
     }
      
//      TransactionService templService=       (TransactionService) ctx.getBean("templateService");
//      templService.dojob();
//      
//	  TransactionService service=       (TransactionService) ctx.getBean("service");
////      TransactionService service = (TransactionService) ctx.getBean("service2");
//	     service.dojob();
//	     service.save();


	}


}
