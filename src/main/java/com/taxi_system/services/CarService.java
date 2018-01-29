package com.taxi_system.services;

import com.taxi_system.dao.CarDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.Car;
import com.taxi_system.db_entities.CarType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Victoria on 04.01.2018.
 */
public class CarService {
    private CarDAO carDAO;

    public CarService() {
        carDAO = FactoryDAO.getCarDAO();
    }

    public List<Car> findAvailableCars(String carTypeString) {
        CarTypeService carTypeService = new CarTypeService();
        CarType carType = carTypeService.getCarTypeByName(carTypeString);
        return carDAO.findAvailableCarByType(carType);
    }

    public void updateCarInDB(Connection connection, Car car) throws SQLException {
        carDAO.updateInDB(connection, car);
    }
}
