package com.perot.training.dayfour;

import java.util.List;
import java.util.Map;

import com.perot.training.dayfour.model.Pet;


public interface DayFourDao {

    List<Map<String, Object>> fetchAll();

    void exceptionCreation();
    
    List<Pet> fetchPet(Pet pet);
}
