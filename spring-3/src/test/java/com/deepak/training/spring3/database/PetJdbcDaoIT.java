package com.deepak.training.spring3.database;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.database.DatabaseConfig;

@ContextConfiguration(classes=DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql("/sql/dml/pet.sql")
public class PetJdbcDaoIT {

    private static final String NEW_PET_OWNER = "Rahul";
    private static final int PET_ID = 5;
    
    @Autowired private PetJdbcDao petJdbcDao;
    
    @BeforeClass
    public static void beforeAnyTest() {
        DBManager.registerDriver();
    }
    
    @Test public void
    whenFetchAll_shouldFetchAllPets() {
        List<Map<String, Object>> allPets = petJdbcDao.fetchAll();
        
        assertThat(allPets, hasSize(5));
    }
    
    @Test public void
    whenUpdatePetOwner_givenValidArgs_shouldUpdateSinbleRowInDb() {
        assertThat(petOwner(), is(equalTo("Sonam")));
        int updateCount = petJdbcDao.updatePetOwner(PET_ID, NEW_PET_OWNER);
        
        assertThat(updateCount, is(equalTo(1)));
        assertThat(petOwner(), is(equalTo(NEW_PET_OWNER)));
    }

    private String petOwner() {
        return petJdbcDao.fetchPetById(PET_ID).getOwner();
    }
}
