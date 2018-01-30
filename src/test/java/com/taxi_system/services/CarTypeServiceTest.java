package com.taxi_system.services;

import com.taxi_system.dao.CarTypeDAO;
import com.taxi_system.db_entities.CarType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CarTypeServiceTest {

    @Mock
    private CarTypeDAO dao;

    private class CarTypeServiceTestImpl extends CarTypeService {
        @Override
        protected CarTypeDAO initCarTypeDAO() {
            return dao;
        }
    }

    @Test
    public void getCarTypes() {
        CarType carType1 = new CarType(1L, "type1", "description", 1);
        CarType carType2 = new CarType(2L, "type2", "description", 1);
        Mockito.when(dao.getCarTypes()).thenReturn(Arrays.asList(carType1, carType2));

        CarTypeService carTypeService = new CarTypeServiceTestImpl();
        List<CarType> result = carTypeService.getCarTypes();

        Assert.assertEquals("Unexpected list size", 2, result.size());
        Assert.assertTrue("Expected car type 1 to be in result", result.contains(carType1));
        Assert.assertTrue("Expected car type 2 to be in result", result.contains(carType2));
    }

    @Test
    public void getCarTypeByName() {
        CarType carType1 = new CarType(1L, "type1", "description", 1);
        String type = "type1";
        Mockito.when(dao.getByName(type)).thenReturn(carType1);

        CarTypeService carTypeService = new CarTypeServiceTestImpl();
        CarType result = carTypeService.getCarTypeByName(type);

        Assert.assertEquals("Expected other carType", carType1, result);
    }
}