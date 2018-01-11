package com.taxi_system.dao.impl;

import com.taxi_system.db_connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public abstract class AbstractCRUD<T> {

    public int create(T object) {
        return executeCommand(getCreateQuery(object));
    }

    public List<T> read(List<String> conditions) {
        List<T> result = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            Connection cn = null;
            try {
                cn = pool.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(getReadQuery(conditionsToString(conditions)));
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            result.add(convertRs(rs));
                        }
                    } catch (SQLException e) {
                      e.printStackTrace();
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(T object) {
        return executeCommand(getUpdateQuery(object));
    }

    public int delete(T object) {
        return executeCommand(getDeleteQuery(object));
    }

    private int executeCommand (String query) {
        int result = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            Connection cn = null;
            try {
                cn = pool.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(query);
                    result = st.executeUpdate();
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    protected abstract String getCreateQuery(T object);
    protected abstract String getReadQuery(String conditions);
    protected abstract String getUpdateQuery(T object);
    protected abstract String getDeleteQuery(T object);
    protected abstract T convertRs(ResultSet rs);
}
