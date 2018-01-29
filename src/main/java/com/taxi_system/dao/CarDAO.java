package com.taxi_system.dao;

import com.taxi_system.db_entities.Car;
import com.taxi_system.db_entities.CarType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface CarDAO {
    List<Car> findAvailableCarByType(CarType carType);
    Car getById(long id);
    void updateInDB(Connection connection, Car car) throws SQLException;
}
