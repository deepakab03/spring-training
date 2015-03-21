package com.deepak.training.spring3.daytwo.proploading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoadingComponentScanEg {

    //will this work, should we use it?
//    @Value("${train.db.driverName}"
    private String dbDriver;

    public PropertyLoadingComponentScanEg() {
    }

    @Autowired
    public PropertyLoadingComponentScanEg( @Value("${train.db.driverName}")String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbDriver() {
        return dbDriver;
    }

}
