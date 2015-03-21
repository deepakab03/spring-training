package com.deepak.training.spring3.daytwo.proploading;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.daytwo.config.propload.DayTwoConfigWithPropertyLoadingUsingEnv;
import com.deepak.training.spring3.daytwo.proploading.PropertyLoadingEg;

@ContextConfiguration(classes=DayTwoConfigWithPropertyLoadingUsingEnv.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyLoadingUsingEnvIT {

    @Autowired private PropertyLoadingEg propertyLoadingEg;

    @Test public void
    whenGetDbDriver_givenDbDriverInjected_shouldReturnTheSame() {
        
        assertThat(propertyLoadingEg.getDbDriver(), is("com.hsql.HSqlDb"));
    }
}
