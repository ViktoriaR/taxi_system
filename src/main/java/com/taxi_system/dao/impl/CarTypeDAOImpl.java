package com.taxi_system.dao.impl;

import com.taxi_system.dao.CarTypeDAO;
import com.taxi_system.db_entities.CarType;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public class CarTypeDAOImpl extends AbstractCRUD<CarType> implements CarTypeDAO {

    @Override
    protected String getCreateQuery(CarType object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO car_type(type, description, coefficient) VALUES('");
        stringBuilder.append(object.getType()).append("', '");
        stringBuilder.append(object.getDescription()).append("', '");
        stringBuilder.append(object.getCoefficient()).append("')");
        return stringBuilder.toString();
    }

    @Override
    protected String getReadQuery(String conditions) {
        return "SELECT * FROM car_type WHERE 1 = 1" + conditions;
    }

    @Override
    protected String getUpdateQuery(CarType object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE car_type SET type = '").append(object.getType());
        stringBuilder.append("', description = '").append(object.getDescription());
        stringBuilder.append("', coefficient = '").append(object.getCoefficient());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    protected String getDeleteQuery(CarType object) {
        return "DELETE FROM car_type WHERE id = " + object.getId();
    }

    @Override
    protected CarType convertRs(ResultSet rs) {
        CarType carType = null;
        try {
            int id = rs.getInt("id");
            String type = rs.getString("type");
            String description = rs.getString("description");
            Float coefficient = rs.getFloat("coefficient");
            carType = new CarType(id, type, description, coefficient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carType;
    }

    @Override
    public List<CarType> getCarTypes() {
        return read(null);
    }

    @Override
    public CarType getByName(String type) {
        List<CarType> list = read(Arrays.asList("type =  '" + type + "'"));
        return list.isEmpty() ? null : list.get(0);
    }
}
