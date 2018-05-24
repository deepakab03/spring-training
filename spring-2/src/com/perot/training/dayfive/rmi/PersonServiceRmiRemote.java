package com.perot.training.dayfive.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.perot.training.dayfour.model.Pet;

public interface PersonServiceRmiRemote extends Remote {
    
    //must throw RemoteException, else run will fail
   List<Pet> fetchPets() throws RemoteException;

}
