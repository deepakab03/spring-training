package com.deepak.training.spring3.database;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Illustrating stored procedure execution
 * @author abrahd2
 *
 */
public class SpringJdbcSpDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public SpringJdbcSpDao(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    
    /**
     * Gives complete control
     */
    public String classicalStoredProcExecution(final int paramValue) {
        String sql = "exec sp_name ?";
        String returnValue = namedParameterJdbcTemplate.getJdbcOperations()
                .execute(sql, new CallableStatementCallback<String>() {

                    @Override
                    public String doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        String returnString = "";

                        cs.setInt(1, paramValue);
                        cs.execute(); // or cs.executeQuery()
                        final ResultSet rs = cs.getResultSet();
                        if (rs.next()) {
                            returnString = rs.getString(1);
                        }
                        return returnString;
                    }
                });

        return returnValue;
    }

}
