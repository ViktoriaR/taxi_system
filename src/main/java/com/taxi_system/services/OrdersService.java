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
import java.util.List;

/**
 * Created by Victoria on 04.01.2018.
 */
public class OrdersService {
    private OrdersDAO ordersDAO;

    public OrdersService() {
        ordersDAO = FactoryDAO.getOrdersDAO();
    }

    public Orders processOrder(Orders order) throws Exception {
        CarService carService = new CarService();
        List<Car> cars = carService.findAvailableCars(order.getCarType());
        if (cars.isEmpty()) throw new Exception("no available car, try again later");
        order.setCar(cars.get(0));

        Connection connection = null;
        try {
            try {
                connection = ConnectionPool.getInstance().getConnection();
                connection.setAutoCommit(false);

                OrdersDAOImpl ordersDAOImpl = FactoryDAO.getOrdersDAO();
                ordersDAOImpl.doExecute(connection, ordersDAOImpl.getCreateQuery(order));

                CarDAOImpl carDAOImpl = FactoryDAO.getCarDAO();
                order.getCar().setAvailable(false);
                carDAOImpl.doExecute(connection, carDAOImpl.getUpdateQuery(order.getCar()));

                ClientDAOImpl clientDAOImpl = FactoryDAO.getClientDAO();
                Client client = order.getClient();
                client.setSum(client.getSum() + order.getPrice());
                clientDAOImpl.doExecute(connection, clientDAOImpl.getUpdateQuery(client));

                connection.commit();
            } catch (SQLException e) {
                if (connection != null) {
                    connection.rollback();
                }
            } finally {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}
