package com.deepak.training.spring3.database;

import java.util.List;
import java.util.Map;

import com.deepak.training.spring3.model.Pet;


public interface DayFourDao {

    List<Map<String, Object>> fetchAll();

    void exceptionCreation();
    
    List<Pet> fetchPet(Pet pet);
}