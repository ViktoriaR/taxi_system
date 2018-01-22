package com.taxi_system.dao;

import com.taxi_system.db_entities.CarDriver;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface CarDriverDAO {
    CarDriver getById(long id);
}
