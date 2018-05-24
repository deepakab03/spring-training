package com.perot.training.dayfive.rmi;

import java.util.List;

import com.perot.training.dayfour.model.Pet;

public interface PersonService{
    
    List<Pet> fetch();
}
