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

public class JdbcDao {
    private static final Log logger = LogFactory.getLog(JdbcDao.class);

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
    
    public Map<String, Object> fetchPetWithId(int petId) throws IllegalStateException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Object> map = null;
        
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select * from pet where id = ?");
            ps.setInt(1, petId);
            rs = ps.executeQuery();
            if (rs == null || !rs.next()) {
                return null;
            }
            
            map = new HashMap<String, Object>();
            map.put("id", rs.getInt("id"));
            map.put("name", rs.getString("name"));
            map.put("owner", rs.getString("owner"));
            map.put("species", rs.getString("species"));
            map.put("sex", rs.getString("sex"));
            map.put("birth", rs.getDate("birth"));
            map.put("death", rs.getDate("death"));
            
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
        return map;

    }

    public int updatePetOwner(int petId, String petOwner) {
        Connection con = DBManager.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("update pet set owner = ? where id = ?");
            ps.setString(1, petOwner);
            ps.setInt(2, petId);
            
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

}
