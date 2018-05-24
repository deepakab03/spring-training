package com.perot.training.dayfive.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perot.training.util.Utils;

public class RmiClient {
    private static final int PORT_NO = 2468;
    private static final Log logger  = LogFactory.getLog(RmiClient.class);

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Utils.initLog4j();

        /*
         * If the object sent from client or returned from server is not in their respective classpaths, then
         * a security manager has to be created. Thus Through Rmi  the import of class definitions not there in the
         * current class path is allowed
         */
        
        /*
         * Old way of lookin up rmi objects on server - still works if server is using spring enabled rmi
         * remoting
         */
        // get a reference to the remote registry
//        Registry registry = LocateRegistry.getRegistry("localhost", PORT_NO);
//        // No security manager required as the objects returned are present in the client class path.
//        PersonServiceRmiRemote pr = (PersonServiceRmiRemote) registry.lookup("personService");
//        logger.info("Pets obtained from remote: " + pr.fetchPets());
//
//        // another way of looking up a remote object stub
//        PersonServiceRmiRemote pr2 = (PersonServiceRmiRemote) Naming.lookup("rmi://localhost:" + PORT_NO
//                + "/personService");
//        logger.info("Pets obtained from remote: " + pr2.fetchPets());
        
        /*
         * Using spring
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/perot/training/dayfive/rmi/springClient.xml");
        PersonService pr = (PersonService) ctx.getBean("mod.personService");
        logger.info("Pets obtained from spring remote: " + pr.fetch());

    }

}
