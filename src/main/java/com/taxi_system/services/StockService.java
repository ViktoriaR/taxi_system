package com.taxi_system.services;

import com.taxi_system.dao.StockDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.Stock;

import java.sql.Timestamp;

/**
 * Created by Victoria on 04.01.2018.
 */
public class StockService {
    private StockDAO stockDAO;

    public StockService() {
        stockDAO = FactoryDAO.getStockDAO();
    }

    public Stock getCurrentStock() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return stockDAO.getStockByTime(currentTime);
    }
}
