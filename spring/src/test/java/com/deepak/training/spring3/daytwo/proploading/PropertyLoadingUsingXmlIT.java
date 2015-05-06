package com.deepak.training.spring3.daytwo.proploading;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.daytwo.proploading.PropertyLoadingEg;

@ContextConfiguration(locations="classpath:spring/daytwo.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyLoadingUsingXmlIT {

    static {
        System.setProperty("newDriverName", "org.sql.Postgres");
    }
    
    @Autowired private PropertyLoadingEg propertyLoadingEg;
    @Autowired private PropertyLoadingEg propertyLoadingEg2;

    @Test public void
    whenGetDbDriver_givenDbDriverInjected_shouldReturnTheSame() {
        
        assertThat(propertyLoadingEg.getDbDriver(), is("org.apache.derby.jdbc.ClientDriver"));
    }
    
    @Test public void
    whenGetDbDriver_givenDbDriverInjectedThroughConstructorSystemProperty_shouldReturnTheSame() {
        
        assertThat(propertyLoadingEg2.getDbDriver(), is("org.sql.Postgres"));
    }
}
