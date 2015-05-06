package com.deepak.training.spring3.database;

 import static java.util.Collections.singletonMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.deepak.training.spring3.model.Pet;

public class PetSpringJdbcDaoImpl  implements PetDao {
	//extends SimpleJdbcDaoSupport
    private static final Log   logger = LogFactory.getLog(PetSpringJdbcDaoImpl.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public PetSpringJdbcDaoImpl(NamedParameterJdbcTemplate simpleJdbcTemplate) {
        super();
        this.namedParameterJdbcTemplate = simpleJdbcTemplate;
    }

    public List<Map<String, Object>> fetchAll() {
        Map<String, ?> emptyMap = Collections.emptyMap();
        List<Map<String, Object>> dataList = namedParameterJdbcTemplate.queryForList("select * from pet", emptyMap);
        for (Map<String, Object> map : dataList) {
            logger.info("Fetched " + map);
        }
        return dataList;

    }

    public void exceptionCreation() {
        Map<String, String> map = Collections.singletonMap("ownerName", "Pappu");
        namedParameterJdbcTemplate.queryForObject("select name from pet where owner= :ownerName", map,  String.class);
    }

    public List<Pet> fetchPetByPetName(Pet pet) {
        String query = "select * from pet where name = :petName";
        RowMapper<Pet> rm = new RowMapper<Pet>() {

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
        Map<String, ?> singletonMap = singletonMap("petName", pet.getName());
        
        return namedParameterJdbcTemplate.query(query,  singletonMap, rm);
    }

    //illustrating beanPropertyMapper
    @Override
    public Pet fetchPetById(long petId) {
        String query = "select * from pet where id = :id";
        Map<String, ?> singletonMap = singletonMap("id", petId);
        RowMapper<Pet> rm = new BeanPropertyRowMapper<Pet>(Pet.class);
        
        return  namedParameterJdbcTemplate.query(query,  singletonMap, rm).get(0);
    }

    //illustrating SqlParameterSource, why is it reqd?
    @Override
    public int updatePetOwner(long petId, String newPetOwner) {
        String sql = "update pet set owner = :owner where id = :id";
        Pet pet = new Pet(petId);
        pet.setOwner(newPetOwner);
        
        SqlParameterSource source = new BeanPropertySqlParameterSource(pet);
//        source = new MapSqlParameterSource().addValue("owner", newPetOwner, Types.VARCHAR)
//                .addValue("id",  petId, Types.INTEGER);
        
        return namedParameterJdbcTemplate.update(sql, source);
    }
}
