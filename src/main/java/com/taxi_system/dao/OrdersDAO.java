package com.taxi_system.dao;

import com.taxi_system.db_entities.Orders;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface OrdersDAO {
    void saveToDB(Connection connection, Orders order) throws SQLException;
}
