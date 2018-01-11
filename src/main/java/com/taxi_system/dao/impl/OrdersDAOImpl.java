package com.taxi_system.dao.impl;

import com.taxi_system.dao.OrdersDAO;
import com.taxi_system.db_entities.Orders;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public class OrdersDAOImpl extends AbstractCRUD<Orders> implements OrdersDAO{

    @Override
    protected String getCreateQuery(Orders object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO orders(client_id, car_id, discount_id, stock_id, arrival_time, from_address, to_address, distance, price) VALUES('");
        stringBuilder.append(object.getClientId()).append("', '");
        stringBuilder.append(object.getCarId()).append("', '");
        stringBuilder.append(object.getDiscountId()).append("', '");
        stringBuilder.append(object.getStockId()).append("', '");
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
        stringBuilder.append("UPDATE orders SET client_id = '").append(object.getClientId());
        stringBuilder.append("', car_id = '").append(object.getCarId());
        stringBuilder.append("', discount_id = '").append(object.getDiscountId());
        stringBuilder.append("', stock_id = '").append(object.getStockId());
        stringBuilder.append("', arrival_time = '").append(object.getArrivalTime());
        stringBuilder.append("', from_address = '").append(object.getFromAddress());
        stringBuilder.append("', to_address = '").append(object.getToAddress());
        stringBuilder.append("', distance = '").append(object.getDistance());
        stringBuilder.append("', price = '").append(object.getPrice());
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
            int id = rs.getInt("id");
            int clientId = rs.getInt("client_id");
            int carId = rs.getInt("car_id");
            int discountId = rs.getInt("discount_id");
            int stockId = rs.getInt("stock_id");
            Timestamp arrivalTime = rs.getTimestamp("arrival_time");
            String fromAddress = rs.getString("from_address");
            String toAddress = rs.getString("to_address");
            float distance = rs.getFloat("distance");
            float price = rs.getFloat("price");
            orders = new Orders(clientId, fromAddress, toAddress);
            orders.id(id).carId(carId).discountId(discountId).stockId(stockId);
            orders.arrivalTime(arrivalTime).distance(distance).price(price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
