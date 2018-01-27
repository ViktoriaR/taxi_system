package com.taxi_system.services;

import com.taxi_system.dao.OrdersDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.dao.impl.CarDAOImpl;
import com.taxi_system.dao.impl.ClientDAOImpl;
import com.taxi_system.dao.impl.OrdersDAOImpl;
import com.taxi_system.db_connection.ConnectionPool;
import com.taxi_system.db_entities.Car;
import com.taxi_system.db_entities.Client;
import com.taxi_system.db_entities.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Victoria on 04.01.2018.
 */
public class OrdersService {
    private OrdersDAO ordersDAO;

    public OrdersService() {
        ordersDAO = FactoryDAO.getOrdersDAO();
    }

    public void createOrderInDB(Connection connection, Orders order) throws SQLException {
        ordersDAO.saveToDB(connection, order);
    }
}
