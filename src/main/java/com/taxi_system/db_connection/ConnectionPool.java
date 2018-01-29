package com.taxi_system.db_connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * Created by Victoria on 23.12.2017.
 */

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();

    private static ConnectionPool instance = null;
    private static final String TOMCAT_JNDI_NAME = "java:comp/env";
    private DataSource pool;
    private final String DATASOURCE;

    private ConnectionPool() {
        Config instance = Config.getInstance();
        DATASOURCE = instance.getProperty(Config.DATASOURCE);
        initialPool();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void initialPool() {
        try {
//            Context initContext = new InitialContext();
//            Context envContext = (Context) initContext.lookup(TOMCAT_JNDI_NAME);
//            pool = (DataSource) envContext.lookup(DATASOURCE);
            pool = hackyInit();
        } catch (Exception e) {
            logger.error("failed to init pool", e);
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("failed to close connection", e);
        }
    }

    public DataSource hackyInit() {
        Config instance = Config.getInstance();
        DataSource ds = new DataSource();
        ds.setDriverClassName(instance.getProperty(Config.DRIVER));
        ds.setUrl(instance.getProperty(Config.URL));
        ds.setUsername(instance.getProperty(Config.USER));
        ds.setPassword(instance.getProperty(Config.PASSWORD));
        ds.setInitialSize(5);
        ds.setMaxActive(100);
        ds.setMaxIdle(10);
        ds.setMinIdle(2);
        ds.setMaxWait(1000);
        return ds;
    }
}
