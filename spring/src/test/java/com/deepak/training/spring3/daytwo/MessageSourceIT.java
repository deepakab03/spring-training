package com.deepak.training.spring3.daytwo;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepak.training.spring3.config.daytwo.DayTwoConfig;

@ContextConfiguration(classes=DayTwoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageSourceIT {
    private static final Logger logger = LoggerFactory.getLogger(MessageSourceIT.class);
    
    //using an applicationContext?
//    @Autowired private ApplicationContext msgSource;
    @Autowired private MessageSource msgSource;
    
    
    @Test public void
    whenGetMessageForNoDetailsFound_givenUSLocale_shouldReturnUSPropValue() throws IOException {
        /*
         * messageSource beans, if US is default locale so _en_US should work.
         */
         logger.info("Current Locale: " + Locale.getDefault());
         String msg = msgSource.getMessage("noDetailsFound", null, "No details found", null);
         
         assertThat(msg, is("No buddy, no details were found for your search"));
    }
    
    @Test public void
    whenGetMessageForNoDetailsFound_givenGBLocaleIsSetAsDefault_shouldReturnGBPropValue() throws IOException {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.UK);
            logger.info("Current Locale2: " + Locale.getDefault());
            String msg = msgSource.getMessage("noDetailsFound", null, "No details found", null);

            assertThat(msg, is("Not really, no details were found for your search"));
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
    
    @Test public void
    whenGetMessage_givenKeyCorrectyButLocalePassedManuallyIsUK_shouldReturnUKPropValue() throws IOException {
        String msg = msgSource.getMessage("noDetailsFound", null, "No details found", Locale.UK);
        
        assertThat(msg, is("Not really, no details were found for your search"));
    }
    
    @Test public void
    whenGetMessage_givenKeyNotInLocalePropsBUTKeyDefinedInDefaultPropsFile_shouldReturnDefaultPropValue() throws IOException {
        String msg = msgSource.getMessage("noDetails", null, "No details found", null);
        
        assertThat(msg, is("No details were found for your search"));
    }
    
    @Test public void
    whenGetMessage_givenKeyNotInLocalePropsANDKeyNOTDefinedInDefaultPropsFile_shouldReturnDefaultValuePassed() throws IOException {
        String msg = msgSource.getMessage("noDet", null, "Not found", null);
        
        assertThat(msg, is("Not found"));
    }
    
    //make this pass?
    @Test public void
    whenGetMessage_givenKeyCorrectyButLocalePassedDoesnNOTHaveAPropFile_shouldReturnDefaultValuePassed() throws IOException {
        String msg = msgSource.getMessage("noDet", null, "Not found2", Locale.GERMAN);
        
        assertThat(msg, is("Not found2"));
    }
    
    @Test public void
    whenGetMessage_givenParameterIsPassed_shouldReturnPropValueWithParametersEmbedded() throws IOException {
        String msg = msgSource.getMessage("enterDetailsToday", new Object[] {new Date()}, "Enter today's details", null);
        logger.info("Message with parameter: {}", msg);
        
        assertThat(msg, containsString("Please enter details for the date "));
    }
    
    //try multpile parameters
    //try - ReloadableResourceBundleMessageSource?
}
