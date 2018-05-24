package com.perot.training.dayfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBManager {
    private static final Log logger = LogFactory.getLog(DBManager.class);

    public static void registerDriver() {
        try {

//            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("net.sf.log4jdbc.DriverSpy").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/training?"
//                    + "user=root&password=root");
            //using log4jdbc
            conn = DriverManager.getConnection("jdbc:log4jdbc:mysql://localhost/training?"
                    + "user=root&password=root");
        } catch (SQLException ex) {
            logger.info("SQLException: " + ex.getMessage());
            logger.info("SQLState: " + ex.getSQLState());
            logger.info("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

}
