package com.perot.training.dayfour;

 import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.perot.training.dayfour.model.Pet;

public class DayFourDaoImpl  implements DayFourDao {
	//extends SimpleJdbcDaoSupport
    private static final Log   logger = LogFactory.getLog(DayFourDaoImpl.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplate;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate template) {
        this.simpleJdbcTemplate = template;
    }

    public List<Map<String, Object>> fetchAll() {
        List<Map<String, Object>> dataList = simpleJdbcTemplate.queryForList("select * from pet");
        for (Map<String, Object> map : dataList) {
            logger.info("Fetched " + map);
        }
        return dataList;

    }

    public void exceptionCreation() {
        Map<String, String> map = Collections.singletonMap("ownerName", "Pappu");
        simpleJdbcTemplate.queryForObject("select name from pet where owner= :ownerName", String.class, map);
    }

    public List<Pet> fetchPet(Pet pet) {
        String query = "select * from pet where name = :petName";
        Map<String,Object> valueMap = new  HashMap<String, Object>();
        valueMap.put("petName", pet.getName());
        SqlParameterSource args = new MapSqlParameterSource(valueMap);
        //new BeanPropertySqlParameterSource(pet);
        ParameterizedRowMapper<Pet> rm = new ParameterizedRowMapper<Pet>() {

            public Pet mapRow(ResultSet rs, int arg1) throws SQLException {
                Pet p = new Pet();

                p.setName(rs.getString("name"));
                p.setOwner(rs.getString("owner"));
                p.setSpecies(rs.getString("species"));
                p.setSex(rs.getString("sex"));
                p.setBirth(rs.getDate("birth"));
                p.setDeath(rs.getDate("death"));
                logger.info("fetched pet-"+p);
                
                return p;
            }
        };
        query = "select * from pet where name = ?";
        return simpleJdbcTemplate.query(query, rm, pet.getName());
//        return simpleJdbcTemplate.query(query, rm, args);
    }

}
