package com.taxi_system.dao.impl;

import com.taxi_system.db_connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public abstract class AbstractCRUD<T> {
    private static final Logger logger = LogManager.getLogger();

    public int create(T object) {
        return executeCommand(getCreateQuery(object));
    }

    public List<T> read(List<String> conditions) {
        List<T> result = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();

        try (Connection cn = pool.getConnection()) {
            result = doRead(cn, getReadQuery(conditionsToString(conditions)));
        } catch (SQLException e) {
            logger.error("read from database failed", e);
        }

        return result;
    }

    public int update(T object) {
        return executeCommand(getUpdateQuery(object));
    }

    public int delete(T object) {
        return executeCommand(getDeleteQuery(object));
    }

    private int executeCommand(String query) {
        int result = 0;
        ConnectionPool pool = ConnectionPool.getInstance();

        try (Connection cn = pool.getConnection()) {
            result = doExecute(cn, query);
        } catch (SQLException e) {
            logger.error("execute command failed", e);
        }

        return result;
    }

    public int doExecute(Connection cn, String query) throws SQLException {
        PreparedStatement st = cn.prepareStatement(query);
        return st.executeUpdate();
    }

    public List<T> doRead(Connection cn, String query) throws SQLException {
        List<T> result = new ArrayList<>();
        PreparedStatement st = cn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            result.add(convertRs(rs));
        }
        return result;
    }

    protected String conditionsToString(List<String> conditions) {
        if (conditions == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (String condition : conditions) {
            stringBuilder.append(" AND ").append(condition);
        }
        return stringBuilder.toString();
    }

    public T getById(long id) {
        List<T> list = read(Arrays.asList("id =  " + id));
        return list.isEmpty() ? null : list.get(0);
    }

    public abstract String getCreateQuery(T object);

    public abstract String getReadQuery(String conditions);

    public abstract String getUpdateQuery(T object);

    public abstract String getDeleteQuery(T object);

    protected abstract T convertRs(ResultSet rs);
}
