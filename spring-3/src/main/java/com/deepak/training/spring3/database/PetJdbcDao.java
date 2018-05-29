package com.deepak.training.spring3.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deepak.training.spring3.exception.SpringTrainRuntimeException;
import com.deepak.training.spring3.model.Pet;

public class PetJdbcDao implements PetDao {
    private static final Log logger = LogFactory.getLog(PetJdbcDao.class);

    public List<Map<String, Object>> fetchAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Map<String, Object>> dataList = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select * from pet");
            rs= ps.executeQuery();
            if (rs == null || !rs.next()) {
                return null;
            }
            dataList = new ArrayList<Map<String, Object>>();
          do {
              Map<String, Object> map =  new HashMap<String, Object>();
              map.put("id", rs.getInt("id"));
              map.put("name", rs.getString("name"));
              map.put("owner", rs.getString("owner"));
              map.put("species", rs.getString("species"));
              map.put("sex", rs.getString("sex"));
              map.put("birth", rs.getDate("birth"));
              map.put("death", rs.getDate("death"));
              
              dataList.add(map);
              
          } while(rs.next());
            
            for (Map<String, Object> map : dataList) {
                logger.info("Fetched " + map);
            }
        } catch (SQLException e) {
            logger.info("stacktrace:",e);
        } finally {
  
            try {
                if (rs!=null) rs.close();
                if (ps!=null) ps.close();
                if(con!=null) con.close();
            } catch (SQLException e) {
                logger.info("stacktrace:",e);
            }
            
        }
        return dataList;

    }
    
    public Pet fetchPetById(long petId) throws IllegalStateException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet pet = null;
        
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select * from pet where id = ?");
            ps.setLong(1, petId);
            rs = ps.executeQuery();
            if (rs == null || !rs.next()) {
                return null;
            }
            
            pet = new Pet();
            pet.setId(rs.getInt("id"));
            pet.setName(rs.getString("name"));
            pet.setOwner(rs.getString("owner"));
            pet.setSpecies(rs.getString("species"));
            pet.setSex(rs.getString("sex"));
            pet.setBirth(rs.getDate("birth"));
            pet.setDeath(rs.getDate("death"));
            
            if (rs.next()) {
                throw new IllegalStateException("Multiple pets found with the same id: " + petId);
            }
        } catch (SQLException e) {
            logger.info("stacktrace:",e);
        } finally {
  
            try {
                if (rs!=null) rs.close();
                if (ps!=null) ps.close();
                if(con!=null) con.close();
            } catch (SQLException e) {
                logger.info("stacktrace:",e);
            }
            
        }
        return pet;

    }

    public int updatePetOwner(long petId, String petOwner) {
        Connection con = DBManager.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("update pet set owner = ? where id = ?");
            ps.setString(1, petOwner);
            ps.setLong(2, petId);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            logger.info("StackTrace:", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                con.close();
            } catch (SQLException e1) {
                logger.info("StackTrace:", e1);
            }
        }
        return 0;
    }

    @Override
    public List<Pet> fetchPetByPetName(Pet pet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void exceptionCreation() {
        throw new SpringTrainRuntimeException("test ex");
    }
}
