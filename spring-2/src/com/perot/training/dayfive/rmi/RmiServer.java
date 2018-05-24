/**
 * 
 */
package com.perot.training.dayfive.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perot.training.dayfour.DayFourMain;
import com.perot.training.util.Utils;

/**
 * @author abrahade
 */
public class RmiServer {

    private static final Log logger = LogFactory.getLog(RmiServer.class);
    public static final int PORT_NO = 2468;

    public static void main(String[] args) throws RemoteException, InterruptedException {
        Utils.initLog4j();
        /*
         * Old way of using rmi
         */
//        PersonServiceImpl psi = new PersonServiceImpl();
//
//        /*
//         * prr has the stub in lieu of the earlier rmic compilation of the remote implementation class that
//         * used to give the stub class
//         */
//        PersonServiceRmiRemote prrStub = (PersonServiceRmiRemote) UnicastRemoteObject.exportObject(psi, 0);
//        Registry registry = LocateRegistry.createRegistry(PORT_NO);
//        
//        registry.rebind("personService", prrStub);
//        logger.info("Bound person service to rmi registry");
        
        /*
         * Rmi using spring, can comment out the extension of Remote by the interface and throwing of RemoteException
         */
        logger.info("Starting spring container");
        new ClassPathXmlApplicationContext("com/perot/training/dayfive/rmi/springServer.xml");
      
        
        logger.info("Waiting for client requests");
        while(true) {
            Thread.sleep(5000);
        }
    }

}
