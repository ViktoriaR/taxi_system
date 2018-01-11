package com.taxi_system.dao.factory;

import com.taxi_system.dao.impl.*;

/**
 * Created by Victoria on 28.12.2017.
 */
public class FactoryDAO {
    private static CarDAOImpl carDAO;
    private static CarDriverDAOImpl carDriverDAO;
    private static CarTypeDAOImpl carTypeDAO;
    private static ClientDAOImpl clientDAO;
    private static DiscountDAOImpl discountDAO;
    private static OrdersDAOImpl ordersDAO;
    private static StockDAOImpl stockDAO;

    private FactoryDAO() {
    }

    public static CarDAOImpl getCarDAO() {
        if (carDAO == null) {
            carDAO = new CarDAOImpl();
        }
        return carDAO;
    }

    public static CarDriverDAOImpl getCarDriverDAO() {
        if (carDriverDAO == null) {
            carDriverDAO = new CarDriverDAOImpl();
        }
        return carDriverDAO;
    }

    public static CarTypeDAOImpl getCarTypeDAO() {
        if (carTypeDAO == null) {
            carTypeDAO = new CarTypeDAOImpl();
        }
        return carTypeDAO;
    }

    public static ClientDAOImpl getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    public static DiscountDAOImpl getDiscountDAO() {
        if (discountDAO == null) {
            discountDAO = new DiscountDAOImpl();
        }
        return discountDAO;
    }

    public static OrdersDAOImpl getOrdersDAO() {
        if (ordersDAO == null) {
            ordersDAO = new OrdersDAOImpl();
        }
        return ordersDAO;
    }

    public static StockDAOImpl getStockDAO() {
        if (stockDAO == null) {
            stockDAO = new StockDAOImpl();
        }
        return stockDAO;
    }
}
