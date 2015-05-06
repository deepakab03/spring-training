package com.deepak.training.spring3.database;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.database.DatabaseConfig;
import com.deepak.training.spring3.model.Pet;

@ContextConfiguration(classes=DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql("/sql/dml/pet.sql")
public class PetHibernateDaoIT {
    private static final String PET_NAME = "Jewel";

    private static final Logger logger = LoggerFactory.getLogger(PetHibernateDaoIT.class);
    
    private static final String PET_OWNER = "Sonam";
    private static final String NEW_PET_OWNER = "Rahul";
    private static final int PET_ID = 5;
    
    @Autowired private PetDao petHibernateDao;
    
    @Test public void
    whenFfetchPetByPetName_shouldFetchRequiredPets() {
        List<Pet> pets = petHibernateDao.fetchPetByPetName(new Pet(PET_NAME));
        
        logger.info("Pets fetched: {}", pets);
        assertThat(pets, hasSize(1));
    }
    
    @Test public void
    whenUpdatePetOwner_givenValidArgs_shouldUpdateSinbleRowInDb() {
        assertThat(petOwner(), is(equalTo(PET_OWNER)));
        int updateCount = petHibernateDao.updatePetOwner(PET_ID, NEW_PET_OWNER);
        
        assertThat(updateCount, is(equalTo(1)));
        assertThat(petOwner(), is(equalTo(NEW_PET_OWNER)));
    }

    private String petOwner() {
        return petHibernateDao.fetchPetById(PET_ID).getOwner();
    }
}
