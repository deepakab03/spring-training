package com.deepak.training.spring3.database;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 * Illustrating stored procedure execution using SimpleJdbcCall for which the databases that provide relevant metadata
 * (accessed via the JDBC driver).
 * 
 * @author abrahd2
 */
public class SpringJdbcSpDao3 {

    private DataSource dataSource;
    private SimpleJdbcCall simpleJdbcCall;

    public SpringJdbcSpDao3(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("sp_name");
    }

    /**
     * Gives complete control
     */
    public String classicalStoredProcExecution(final int paramValue) {
        //or pass a map, but the key should be the value of the in param specified in the SP.
        Map<String, Object> outMap = simpleJdbcCall.execute(paramValue);
        //while getting values, we don't NEED to use the prefix 'out_', that is an eg
        return (String) outMap.get("out_name");
    }

}
