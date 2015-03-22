package com.deepak.training.spring3.config.daytwo.propload;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig implements InitializingBean {

    @Value("${train.sample.email}") private String sampleTrainEmail;
    @Value("${train.db.driverName}") private String trainDbDriverName;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!sampleTrainEmail.endsWith(".com")) {
            throw new IllegalStateException("Have to have an email ending with .com");
        }
    }
    
    public String getSampleTrainEmail() {
        return sampleTrainEmail;
    }

    public String getTrainDbDriverName() {
        return trainDbDriverName;
    }
}
