package com.taxi_system.dao;

import com.taxi_system.db_entities.Discount;

/**
 * Created by Victoria on 25.12.2017.
 */
public interface DiscountDAO {
    Discount getDiscountOnSum(float sum);
    Discount getById(long id);
}
