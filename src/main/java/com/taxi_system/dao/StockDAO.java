package com.taxi_system.dao;

import com.taxi_system.db_entities.Stock;

import java.sql.Timestamp;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface StockDAO {
    Stock getStockByTime(Timestamp time);
    Stock getById(long id);
}
