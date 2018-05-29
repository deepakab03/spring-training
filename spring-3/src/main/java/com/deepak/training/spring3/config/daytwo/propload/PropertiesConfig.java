package com.deepak.training.spring3.config.daytwo.propload;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig implements InitializingBean {

    @Value("${train.sample.email}") private String sampleTrainEmail;
    //specifying a default value for a property, use propName:default-value
    @Value("${some.unknown.prop:xyz}") private String propertyNotDefinedInPropfile;
    
    @Value("${train.db.driver_name}") private String trainingDbDriverClass;
    @Value("${train.db.url}") private String trainingDbUrl;
    @Value("${tran.db.username}") private String trainingDbUsername;
    @Value("${tran.db.password}") private String trainingDbPassword;
    
    public String getPropertyNotDefinedInPropfile() {
        return propertyNotDefinedInPropfile;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!sampleTrainEmail.endsWith(".com")) {
            throw new IllegalStateException("Have to have an email ending with .com");
        }
    }
    
    public String getSampleTrainEmail() {
        return sampleTrainEmail;
    }

    public String getTrainingDbDriverClass() {
        return trainingDbDriverClass;
    }

    public String getTrainingDbUrl() {
        return trainingDbUrl;
    }

    public String getTrainingDbUsername() {
        return trainingDbUsername;
    }

    public String getTrainingDbPassword() {
        return trainingDbPassword;
    }
}
