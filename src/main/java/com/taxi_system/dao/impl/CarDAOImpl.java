package com.taxi_system.dao.impl;

import com.taxi_system.dao.CarDAO;
import com.taxi_system.db_entities.Car;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public class CarDAOImpl extends AbstractCRUD<Car> implements CarDAO {

    @Override
    protected String getCreateQuery(Car object) {
        StringBuilder stringBuilder = new StringBuilder("INSERT INTO car(type_id, driver_id, model, number, available, location) VALUES(");
        stringBuilder.append(object.getCarTypeId()).append(", ");
        stringBuilder.append(object.getCarDriverId()).append(", '");
        stringBuilder.append(object.getModel()).append("', '");
        stringBuilder.append(object.getNumber()).append("', ");
        stringBuilder.append(object.isAvailable()).append(", '");
        stringBuilder.append(object.getLocation()).append("')");
        return stringBuilder.toString();
    }

    @Override
    protected String getReadQuery(String conditions) {
        return "SELECT * FROM car WHERE 1 = 1" + conditions;
    }

    @Override
    protected String getUpdateQuery(Car object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE car SET type_id = ").append(object.getCarTypeId());
        stringBuilder.append(", driver_id = ").append(object.getCarDriverId());
        stringBuilder.append(", model = '").append(object.getModel());
        stringBuilder.append("', number = '").append(object.getNumber());
        stringBuilder.append("', available = ").append(object.isAvailable());
        stringBuilder.append(", location = '").append(object.getLocation());
        stringBuilder.append("' WHERE id = ").append(object.getId());
        return stringBuilder.toString();
    }

    @Override
    protected String getDeleteQuery(Car object) {
        return "DELETE FROM car WHERE id = " + object.getId();
    }

    @Override
    protected Car convertRs(ResultSet rs) {
        Car car = null;
        try {
            int id = rs.getInt("id");
            Integer type_id = rs.getInt("type_id");
            type_id = type_id != 0 ? type_id : null;
            Integer driver_id = rs.getInt("driver_id");
            driver_id = driver_id != 0 ? driver_id : null;
            String model = rs.getString("model");
            String number = rs.getString("number");
            boolean available = rs.getBoolean("available");
            String location = rs.getString("location");
            car = new Car(id, type_id, driver_id, model, number, available, location);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> findAvailableCarByTypeId(int carTypeId) {
        return read(Arrays.asList("type_id = " + carTypeId, "available = true"));
    }

    @Override
    public boolean changeCarStatus(int carId, boolean available) {
        boolean result = true;
        List<Car> cars = read(Arrays.asList("id = " + carId));
        if(cars.size() < 1) result = false;
        Car car = cars.get(0);
        car.setAvailable(available);
        update(car);
        return result;
    }
}
