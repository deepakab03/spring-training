/**
 * 
 */
package com.perot.training.dayfive.rmi;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.perot.training.dayfour.model.Pet;

/**
 * @author abrahade
 *
 */
public class PersonServiceImpl implements PersonService {
    //, PersonServiceRmiRemote
    
    private static final Log logger = LogFactory.getLog(PersonServiceImpl.class);

    /* (non-Javadoc)
     * @see com.perot.training.dayfive.rmi.PersonServiceRmiRemote#fetchPets()
     */
//    @Override
//    public List<Pet> fetchPets() throws RemoteException {
//        logger.info("Got a remote call");
//        return Collections.singletonList(Pet.createTestPet());
//    }

    public List<Pet> fetch() {
        logger.info("Got a remote spring call");
        return Collections.singletonList(Pet.createTestPet());
    }

    

}
