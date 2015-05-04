package com.deepak.training.spring3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBManager {
    private static final Log logger = LogFactory.getLog(DBManager.class);

    public static void registerDriver() {
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//            Class.forName("net.sf.log4jdbc.DriverSpy").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //if using only ij to connect to a derby db
//            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/spring_train;create=false");
            //when using a username and pwd to connect when using squirrel for eg
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/spring_train;create=false", 
                    "spring_train", "spring_train");
            //using log4jdbc
//            conn = DriverManager.getConnection("jdbc:log4jdbc:mysql://localhost/training?"
//                    + "user=root&password=root");
        } catch (SQLException ex) {
            logger.info("SQLException: " + ex.getMessage());
            logger.info("SQLState: " + ex.getSQLState());
            logger.info("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

}
