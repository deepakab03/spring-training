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
        Connection con = DBManager.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Map<String, Object>> dataList = null;
        try {
            ps = con.prepareStatement("select * from pet");
            rs= ps.executeQuery();
            if (rs == null || !rs.next()) {
                return null;
            }
            dataList = new ArrayList<Map<String, Object>>();
          do {
              Map<String, Object> map =  new HashMap<String, Object>();
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
                if(con!=null) con.close();
                if (ps!=null) ps.close();
                if (rs!=null) rs.close();
            } catch (SQLException e) {
                logger.info("stacktrace:",e);
            }
            
        }
        return dataList;

    }

}
