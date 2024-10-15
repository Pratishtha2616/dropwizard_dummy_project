package com.test.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;

import java.util.Objects;

//configuration
public class BRSConfiguration extends Configuration {
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        //get the things in a singleton pattern
        if(Objects.isNull(database)) {
            database = new DataSourceFactory();
        }
        return database;

    }

   @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }
}
