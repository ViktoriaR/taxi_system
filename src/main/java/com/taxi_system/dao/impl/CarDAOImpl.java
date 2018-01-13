package com.taxi_system.dao.impl;

import com.taxi_system.dao.CarDAO;
import com.taxi_system.dao.CarDriverDAO;
import com.taxi_system.dao.CarTypeDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.Car;
import com.taxi_system.db_entities.CarDriver;
import com.taxi_system.db_entities.CarType;
import javafx.util.Pair;

import java.sql.Driver;
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
        stringBuilder.append(object.getCarType().getId()).append(", ");
        stringBuilder.append(object.getCarDriver().getId()).append(", '");
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
        stringBuilder.append("UPDATE car SET type_id = ").append(object.getCarType().getId());
        stringBuilder.append(", driver_id = ").append(object.getCarDriver().getId());
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
            CarTypeDAO carTypeDAO = FactoryDAO.getCarTypeDAO();
            CarDriverDAO carDriverDAO = FactoryDAO.getCarDriverDAO();
            Integer type_id = rs.getInt("type_id");
            CarType carType = carTypeDAO.getById(type_id);
            Integer driver_id = rs.getInt("driver_id");
            CarDriver carDriver = carDriverDAO.getById(driver_id);
            String model = rs.getString("model");
            String number = rs.getString("number");
            boolean available = rs.getBoolean("available");
            String location = rs.getString("location");
            car = new Car(id, carType, carDriver, model, number, available, location);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> findAvailableCarByType(CarType carType) {
        return read(Arrays.asList("type_id = " + carType.getId(), "available = true"));
    }

    @Override
    public boolean changeCarStatus(Car car, boolean available) {
        if (car == null) return false;
        car.setAvailable(available);
        List<Car> cars = read(Arrays.asList("id = " + car.getId()));
        if (cars.isEmpty()) return false;
        Car carInDB = cars.get(0);
        if (carInDB.isAvailable() == car.isAvailable()) return false;
        update(car);
        return true;
    }
}
