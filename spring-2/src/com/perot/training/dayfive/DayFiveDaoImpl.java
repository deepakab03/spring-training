package com.perot.training.dayfive;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.perot.training.dayfour.DayFourDao;
import com.perot.training.dayfour.model.Pet;

public class DayFiveDaoImpl implements DayFourDao {
	private static final Log logger = LogFactory.getLog(DayFiveDaoImpl.class);

	private SimpleJdbcTemplate simpleJdbcTemplate;

	public DayFiveDaoImpl() {
	}

	public DayFiveDaoImpl(String servicename, TrafficLightEnum light) {
		logger.info("Service name is " + servicename + " light is " + light);
	}

	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate template) {
		this.simpleJdbcTemplate = template;
	}

	public List<Map<String, Object>> fetchAll() {
		List<Map<String, Object>> dataList = simpleJdbcTemplate
				.queryForList("select * from pet");
		// List<Map<String,Object>> dataList =
		// simpleJdbcTemplate.queryForList("select * from pet where name='jeeva'");
		for (Map<String, Object> map : dataList) {
			logger.info("Fetched " + map);
		}
		return dataList;

	}

	public void exceptionCreation() {
		Map<String, String> map = Collections
				.singletonMap("ownerName", "Pappu");
		simpleJdbcTemplate.queryForObject(
				"select name from pet where owner= :ownerName", String.class,
				map);
	}

	public List<Pet> fetchPet(Pet pet) {
		String query = "select * from pet where name = :name";
		SqlParameterSource args = new BeanPropertySqlParameterSource(pet);
		ParameterizedRowMapper<Pet> rm = new ParameterizedRowMapper<Pet>() {

			public Pet mapRow(ResultSet rs, int arg1) throws SQLException {
				Pet p = new Pet();

				p.setName(rs.getString("name"));
				p.setOwner(rs.getString("owner"));
				p.setSpecies(rs.getString("species"));
				p.setSex(rs.getString("sex"));
				p.setBirth(rs.getDate("birth"));
				p.setDeath(rs.getDate("death"));
				logger.info("fetched pet-" + p);

				return p;
			}
		};

		return simpleJdbcTemplate.query(query, rm, args);
	}

}
