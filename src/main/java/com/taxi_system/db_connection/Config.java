package com.taxi_system.db_connection;

import java.util.ResourceBundle;

/**
 * Created by Victoria on 23.12.2017.
 */

public class Config {
    private static Config instance;
    private ResourceBundle resource;
    public static final String DATASOURCE = "DATASOURCE";
    private static final String BUNDLE_NAME = "config";
    public static final String DRIVER = "DRIVER";
    public static final String URL = "URL";
    public static final String USER = "USER";
    public static final String PASSWORD = "PASSWORD";

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
