package com.deepak.training.spring3.database;

import static org.hamcrest.Matchers.hasSize;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.database.DatabaseConfig;

@ContextConfiguration(classes=DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcDaoIT {

    @Autowired private JdbcDao jdbcDao;
    
    @Test public void
    whenFetchAll_shouldFetchAllPets() {
        List<Map<String, Object>> allPets = jdbcDao.fetchAll();
        
        Assert.assertThat(allPets, hasSize(5));
    }
}
