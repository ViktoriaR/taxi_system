package com.taxi_system.services;

import com.taxi_system.dao.CarDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.dao.impl.CarDAOImpl;
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
        carDAO = initCarDAO();
    }

    /**
     * This method returns <code>List<Car></code> of available cars from db,
     * or <code>null</code> if no available cars in db
     *
     * @param carTypeString servlet request
     * @return a <code>List<Car></code> of available cars from db
     */
    public List<Car> findAvailableCars(String carTypeString) {
        CarTypeService carTypeService = getCarTypeService();
        CarType carType = carTypeService.getCarTypeByName(carTypeString);
        return carDAO.findAvailableCarByType(carType);
    }

    /**
     * This method add update SQL statements to transaction in connection
     *
     * @param connection to db
     * @param car is Car, that should be update
     */
    public void updateCarInDB(Connection connection, Car car) throws SQLException {
        carDAO.updateInDB(connection, car);
    }

    protected CarDAO initCarDAO() {
        return FactoryDAO.getCarDAO();
    }

    protected CarTypeService getCarTypeService() {
        return new CarTypeService();
    }
}
