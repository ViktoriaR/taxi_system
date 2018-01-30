package com.taxi_system.services;

import com.taxi_system.dao.CarDAO;
import com.taxi_system.db_entities.Car;
import com.taxi_system.db_entities.CarType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarDAO dao;
    @Mock
    private CarTypeService carTypeService;

    private Car car = new Car(1L, null, null, null, null, true, null);

    private class CarServiceTestImpl extends CarService {
        @Override
        protected CarDAO initCarDAO() {
            return dao;
        }

        @Override
        protected CarTypeService getCarTypeService() {
            return carTypeService;
        }
    }

    @Test
    public void findAvailableCars() {
        String carTypeString = "carType";
        CarType carType = new CarType(1L, "carType", "description", 1);
        List<Car> cars = Collections.singletonList(car);
        Mockito.when(carTypeService.getCarTypeByName(carTypeString)).thenReturn(carType);
        Mockito.when(dao.findAvailableCarByType(Mockito.eq(carType))).thenReturn(cars);

        CarService carService = new CarServiceTestImpl();
        List<Car> result = carService.findAvailableCars(carTypeString);

        Assert.assertEquals("Expected another arrayList", cars, result);
    }

    @Test
    public void updateCarInDB() throws SQLException {
        Connection connection = null;

        CarService carService = new CarServiceTestImpl();
        carService.updateCarInDB(connection, car);

        Mockito.verify(dao).updateInDB(Mockito.eq(connection), Mockito.eq(car));
    }
}