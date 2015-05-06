package com.deepak.training.spring3.database;

import java.util.List;
import java.util.Map;

import com.deepak.training.spring3.model.Pet;


public interface PetDao {

    List<Map<String, Object>> fetchAll();

    void exceptionCreation();
    
    List<Pet> fetchPetByPetName(Pet pet);

    Pet fetchPetById(long petId);

    int updatePetOwner(long petId, String newPetOwner);
}
