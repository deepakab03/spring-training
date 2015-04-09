package com.deepak.training.spring3.database;

import javax.sql.DataSource;

import org.springframework.jdbc.object.StoredProcedure;

/**
 * Illustrating stored procedure execution using <code>StoredProcedure</code> class
 * (accessed via the JDBC driver).
 * 
 * @author abrahd2
 */
public class SpringJdbcSpDao2 {

    private DataSource dataSource;
    
    private static class MyStoredProc extends StoredProcedure {
        
    }

    public SpringJdbcSpDao2(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Gives complete control
     */
    public String classicalStoredProcExecution(final int paramValue) {
        return null;
    }

}
