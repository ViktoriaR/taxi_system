package com.taxi_system.dao.impl;

import com.taxi_system.dao.DiscountDAO;
import com.taxi_system.db_entities.Discount;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public class DiscountDAOImpl extends AbstractCRUD<Discount> implements DiscountDAO{

    @Override
    public String getCreateQuery(Discount object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO discount(percent, bottom_sum, upper_sum, description) VALUES('");
        stringBuilder.append(object.getPercent()).append("', '");
        stringBuilder.append(object.getBottomSum()).append("', '");
        stringBuilder.append(object.getUpperSum()).append("', '");
        stringBuilder.append(object.getDescription()).append("')");
        return stringBuilder.toString();
    }

    @Override
    public String getReadQuery(String conditions) {
        return "SELECT * FROM discount WHERE 1 = 1" + conditions;
    }

    @Override
    public String getUpdateQuery(Discount object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE discount SET percent = '").append(object.getPercent());
        stringBuilder.append("', bottom_sum = '").append(object.getBottomSum());
        stringBuilder.append("', upper_sum = '").append(object.getUpperSum());
        stringBuilder.append("', description = '").append(object.getDescription());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    public String getDeleteQuery(Discount object) {
        return "DELETE FROM discount WHERE id = " + object.getId();
    }

    @Override
    protected Discount convertRs(ResultSet rs) {
        Discount discount = null;
        try {
            long id = rs.getLong("id");
            float percent = rs.getFloat("percent");
            long bottomSum = rs.getLong("bottom_sum");
            long upperSum = rs.getLong("upper_sum");
            String description = rs.getString("description");
            discount = new Discount(id, percent, bottomSum, upperSum, description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public Discount getDiscountOnSum(float sum) {
        List<Discount> list = read(Arrays.asList("bottom_sum <= " + sum, "upper_sum > " + sum));
        return list.isEmpty() ? null : list.get(0);
    }
}
