package com.taxi_system.dao;

import com.taxi_system.db_entities.Car;

import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface CarDAO {
    List<Car> findAvailableCarByTypeId(int carTypeId);

    boolean changeCarStatus(int carId, boolean available);
}
