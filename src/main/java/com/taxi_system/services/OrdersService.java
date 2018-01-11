package com.taxi_system.services;

import com.taxi_system.dao.OrdersDAO;
import com.taxi_system.dao.factory.FactoryDAO;

/**
 * Created by Victoria on 04.01.2018.
 */
public class OrdersService {
    private OrdersDAO ordersDAO;

    public OrdersService() {
        ordersDAO = FactoryDAO.getOrdersDAO();
    }


}
