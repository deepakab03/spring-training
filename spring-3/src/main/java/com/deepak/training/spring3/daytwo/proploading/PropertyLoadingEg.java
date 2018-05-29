package com.deepak.training.spring3.daytwo.proploading;


public class PropertyLoadingEg {

    private String dbDriver;

    public PropertyLoadingEg() {
    }

    public PropertyLoadingEg(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbDriver() {
        return dbDriver;
    }
}
