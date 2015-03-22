package com.deepak.training.spring3.daytwo.proploading;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.propload.DayTwoConfigWithPropertyLoadingComponentScan;

@ContextConfiguration(classes=DayTwoConfigWithPropertyLoadingComponentScan.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyLoadingUsingComponentScan {

    @Autowired private PropertyLoadingComponentScanEg propertyLoadingAnnotationEg;

    @Test public void
    whenGetDbDriver_givenDbDriverInjected_shouldReturnTheSame() {
        
        assertThat(propertyLoadingAnnotationEg.getDbDriver(), is("com.hsql.HSqlDb"));
    }
}
