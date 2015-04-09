package com.deepak.training.spring3.daytwo.proploading;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.propload.DayTwoConfigWithPropertyLoadingUsingPropertiesConfig;

@ContextConfiguration(classes=DayTwoConfigWithPropertyLoadingUsingPropertiesConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyLoadingUsingPropertiesConfigIT {

    @Autowired private PropertyLoadingUsingPropertiesConfig propertyLoadingUsingPropertiesConfig;

    @Test public void
    whenGetDbDriver_givenDbDriverInjected_shouldReturnTheSame() {
        
        assertThat(propertyLoadingUsingPropertiesConfig.getDbDriver(), is("com.hsql.HSqlDb"));
    }
    
    @Test public void
    whenGetSampleTrainEmail_givenEmailIsConfigured_shouldReturnTheSame() {
        
        assertThat(propertyLoadingUsingPropertiesConfig.getSampleTrainEmail(), is("abc@dbe.com"));
    }
    
    @Test public void
    whenGetPropertyNotInPropetyFile_givenDefaultIsGiven_shouldReturnTheSame() {
        
        assertThat(propertyLoadingUsingPropertiesConfig.getPropertyNotDefinedInPropfile(), is("xyz"));
    }
}
