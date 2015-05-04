package com.deepak.training.spring3.database;

 import static java.util.Collections.singletonMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.deepak.training.spring3.model.PetOld;

public class DayFourDaoImpl  implements DayFourDao {
	//extends SimpleJdbcDaoSupport
    private static final Log   logger = LogFactory.getLog(DayFourDaoImpl.class);

    private NamedParameterJdbcTemplate simpleJdbcTemplate;

    public List<Map<String, Object>> fetchAll() {
        Map<String, ?> emptyMap = Collections.emptyMap();
        List<Map<String, Object>> dataList = simpleJdbcTemplate.queryForList("select * from pet", emptyMap);
        for (Map<String, Object> map : dataList) {
            logger.info("Fetched " + map);
        }
        return dataList;

    }

    public void exceptionCreation() {
        Map<String, String> map = Collections.singletonMap("ownerName", "Pappu");
        simpleJdbcTemplate.queryForObject("select name from pet where owner= :ownerName", map,  String.class);
    }

    public List<PetOld> fetchPet(PetOld petOld) {
        String query = "select * from pet where name = :petName";
        Map<String,Object> valueMap = new  HashMap<String, Object>();
        valueMap.put("petName", petOld.getName());
//        SqlParameterSource args = new MapSqlParameterSource(valueMap);
        //new BeanPropertySqlParameterSource(pet);
        RowMapper<PetOld> rm = new RowMapper<PetOld>() {

            public PetOld mapRow(ResultSet rs, int arg1) throws SQLException {
                PetOld p = new PetOld();

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
        Map<String, ?> singletonMap = singletonMap("petName", petOld.getName());
        return simpleJdbcTemplate.query(query,  singletonMap, rm);
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate template) {
        this.simpleJdbcTemplate = template;
    }
}
