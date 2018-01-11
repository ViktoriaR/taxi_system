package com.taxi_system.dao;

import com.taxi_system.db_entities.CarType;

import java.util.List;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface CarTypeDAO {
    List<CarType> getCarTypes();
}
