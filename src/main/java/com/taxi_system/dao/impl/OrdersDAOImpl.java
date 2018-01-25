package com.taxi_system.dao.impl;

import com.taxi_system.dao.*;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Victoria on 25.12.2017.
 */
public class OrdersDAOImpl extends AbstractCRUD<Orders> implements OrdersDAO {

    @Override
    public String getCreateQuery(Orders object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO orders(client_id, car_id, discount_id, stock_id, from_address, to_address, distance, price) VALUES(");
        Long clientId = object.getClient() == null ? null : object.getClient().getId();
        stringBuilder.append(clientId).append(", ");
        Long carId = object.getCar() == null ? null : object.getCar().getId();
        stringBuilder.append(carId).append(", ");
        Long discountId = object.getDiscount() == null ? null : object.getDiscount().getId();
        stringBuilder.append(discountId).append(", ");
        Long stockId = object.getStock() == null ? null : object.getStock().getId();
        stringBuilder.append(stockId).append(", '");
        stringBuilder.append(object.getFromAddress()).append("', '");
        stringBuilder.append(object.getToAddress()).append("', '");
        stringBuilder.append(object.getDistance()).append("', '");
        stringBuilder.append(object.getPrice()).append("')");
        return stringBuilder.toString();
    }

    @Override
    public String getReadQuery(String conditions) {
        return "SELECT * FROM orders WHERE 1 = 1" + conditions;
    }

    @Override
    public String getUpdateQuery(Orders object) {
        StringBuilder stringBuilder = new StringBuilder();
        Long clientId = object.getClient() == null ? null : object.getClient().getId();
        stringBuilder.append("UPDATE orders SET client_id = ").append(clientId);
        Long carId = object.getCar() == null ? null : object.getCar().getId();
        stringBuilder.append(", car_id = ").append(carId);
        Long discountId = object.getDiscount() == null ? null : object.getDiscount().getId();
        stringBuilder.append(", discount_id = ").append(discountId);
        Long stockId = object.getStock() == null ? null : object.getStock().getId();
        stringBuilder.append(", stock_id = ").append(stockId);
        stringBuilder.append(", from_address = '").append(object.getFromAddress());
        stringBuilder.append("', to_address = '").append(object.getToAddress());
        stringBuilder.append("', setDistance = '").append(object.getDistance());
        stringBuilder.append("', setPrice = '").append(object.getPrice());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    public String getDeleteQuery(Orders object) {
        return "DELETE FROM orders WHERE id = " + object.getId();
    }

    @Override
    protected Orders convertRs(ResultSet rs) {
        Orders orders = null;
        try {
            ClientDAO clientDAO = FactoryDAO.getClientDAO();
            CarDAO carDAO = FactoryDAO.getCarDAO();
            DiscountDAO discountDAO = FactoryDAO.getDiscountDAO();
            StockDAO stockDAO = FactoryDAO.getStockDAO();
            long id = rs.getLong("id");
            long clientId = rs.getLong("client_id");
            Client client = clientDAO.getById(clientId);
            long carId = rs.getLong("car_id");
            Car car = carDAO.getById(carId);
            long discountId = rs.getLong("discount_id");
            Discount discount = discountDAO.getById(discountId);
            long stockId = rs.getLong("stock_id");
            Stock stock = stockDAO.getById(stockId);
            String fromAddress = rs.getString("from_address");
            String toAddress = rs.getString("to_address");
            float distance = rs.getFloat("setDistance");
            float price = rs.getFloat("setPrice");
            orders = new Orders(fromAddress, toAddress, null);
            orders.setClient(client).setId(id).setCar(car).setDiscount(discount).setStock(stock);
            orders.setDistance(distance).setPrice(price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveToDB(Connection connection, Orders order) throws SQLException {
        doExecute(connection, getCreateQuery(order));
    }
}
