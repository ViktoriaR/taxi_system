package com.taxi_system.dao.impl;

import com.taxi_system.dao.*;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Victoria on 25.12.2017.
 */
public class OrdersDAOImpl extends AbstractCRUD<Orders> implements OrdersDAO{

    @Override
    protected String getCreateQuery(Orders object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO orders(client_id, car_id, discount_id, stock_id, arrival_time, from_address, to_address, setDistance, setPrice) VALUES('");
        stringBuilder.append(object.getClient().getId()).append("', '");
        stringBuilder.append(object.getCar().getId()).append("', '");
        stringBuilder.append(object.getDiscount().getId()).append("', '");
        stringBuilder.append(object.getStock().getId()).append("', '");
        stringBuilder.append(object.getArrivalTime()).append("', '");
        stringBuilder.append(object.getFromAddress()).append("', '");
        stringBuilder.append(object.getToAddress()).append("', '");
        stringBuilder.append(object.getDistance()).append("', '");
        stringBuilder.append(object.getPrice()).append("')");
        return stringBuilder.toString();
    }

    @Override
    protected String getReadQuery(String conditions) {
        return "SELECT * FROM orders WHERE 1 = 1" + conditions;
    }

    @Override
    protected String getUpdateQuery(Orders object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE orders SET client_id = '").append(object.getClient().getId());
        stringBuilder.append("', car_id = '").append(object.getCar().getId());
        stringBuilder.append("', discount_id = '").append(object.getDiscount().getId());
        stringBuilder.append("', stock_id = '").append(object.getStock().getId());
        stringBuilder.append("', arrival_time = '").append(object.getArrivalTime());
        stringBuilder.append("', from_address = '").append(object.getFromAddress());
        stringBuilder.append("', to_address = '").append(object.getToAddress());
        stringBuilder.append("', setDistance = '").append(object.getDistance());
        stringBuilder.append("', setPrice = '").append(object.getPrice());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    protected String getDeleteQuery(Orders object) {
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
            int id = rs.getInt("id");
            int clientId = rs.getInt("client_id");
            Client client = clientDAO.getById(clientId);
            int carId = rs.getInt("car_id");
            Car car = carDAO.getById(carId);
            int discountId = rs.getInt("discount_id");
            Discount discount = discountDAO.getById(discountId);
            int stockId = rs.getInt("stock_id");
            Stock stock = stockDAO.getById(stockId);
            Timestamp arrivalTime = rs.getTimestamp("arrival_time");
            String fromAddress = rs.getString("from_address");
            String toAddress = rs.getString("to_address");
            float distance = rs.getFloat("setDistance");
            float price = rs.getFloat("setPrice");
            orders = new Orders(client, fromAddress, toAddress);
            orders.setId(id).setCar(car).setDiscount(discount).setStock(stock);
            orders.setArrivalTime(arrivalTime).setDistance(distance).setPrice(price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
