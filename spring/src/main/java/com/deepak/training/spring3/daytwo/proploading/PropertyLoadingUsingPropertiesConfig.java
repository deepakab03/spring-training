package com.deepak.training.spring3.daytwo.proploading;

import com.deepak.training.spring3.config.daytwo.propload.PropertiesConfig;

public class PropertyLoadingUsingPropertiesConfig {

    private String dbDriver;
    
    private PropertiesConfig propertiesConfig;
    
    public PropertyLoadingUsingPropertiesConfig() {
    }

    public PropertyLoadingUsingPropertiesConfig(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getSampleTrainEmail() {
        return propertiesConfig.getSampleTrainEmail();
    }

    public void setConfigProperties(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
    }
    
    public String getPropertyNotDefinedInPropfile() {
        return propertiesConfig.getPropertyNotDefinedInPropfile();
    }
}
