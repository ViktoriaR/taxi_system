package com.taxi_system.dao.impl;

import com.taxi_system.dao.StockDAO;
import com.taxi_system.db_entities.Stock;

import java.sql.*;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public class StockDAOImpl extends AbstractCRUD<Stock> implements StockDAO {

    @Override
    public String getCreateQuery(Stock object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO stock(percent, start_date, end_date, description) VALUES('");
        stringBuilder.append(object.getPercent()).append("', '");
        stringBuilder.append(object.getStartDate()).append("', '");
        stringBuilder.append(object.getEndDate()).append("', '");
        stringBuilder.append(object.getDescription()).append("')");
        return stringBuilder.toString();
    }

    @Override
    public String getReadQuery(String conditions) {
        return "SELECT * FROM stock WHERE 1 = 1" + conditions;
    }

    @Override
    public String getUpdateQuery(Stock object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE stock SET percent = '").append(object.getPercent());
        stringBuilder.append("', start_date = '").append(object.getStartDate());
        stringBuilder.append("', end_date = '").append(object.getEndDate());
        stringBuilder.append("', description = '").append(object.getDescription());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    public String getDeleteQuery(Stock object) {
        return "DELETE FROM stock WHERE id = " + object.getId();
    }

    @Override
    protected Stock convertRs(ResultSet rs) {
        Stock stock = null;
        try {
            long id = rs.getLong("id");
            float percent = rs.getFloat("percent");
            Timestamp startDate = rs.getTimestamp("start_date");
            Timestamp endDate = rs.getTimestamp("end_date");
            String description = rs.getString("description");
            stock = new Stock(id, percent, startDate, endDate, description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public Stock getStockByTime(Timestamp time) {
        List<Stock> stocks = read(null);
        Stock result = null;
        for (Stock stock: stocks) {
            if (time.after(stock.getStartDate()) && time.before(stock.getEndDate())){
                result = stock;
                break;
            }
        }
        return result;
    }
}
