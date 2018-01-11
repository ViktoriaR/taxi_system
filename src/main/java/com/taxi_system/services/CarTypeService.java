package com.taxi_system.services;

import com.taxi_system.dao.CarTypeDAO;
import com.taxi_system.dao.factory.FactoryDAO;
import com.taxi_system.db_entities.CarType;

import java.util.List;

/**
 * Created by Victoria on 04.01.2018.
 */
public class CarTypeService {
    private CarTypeDAO carTypeDAO;

    public CarTypeService() {
        carTypeDAO = FactoryDAO.getCarTypeDAO();
    }

    public List<CarType> getCarTypes() {
        return carTypeDAO.getCarTypes();
    }
}
