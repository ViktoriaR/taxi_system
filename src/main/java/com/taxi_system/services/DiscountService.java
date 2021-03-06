package com.taxi_system.services;

import com.taxi_system.dao.DiscountDAO;
import com.taxi_system.dao.impl.DiscountDAOImpl;
import com.taxi_system.db_entities.Client;
import com.taxi_system.db_entities.Discount;

/**
 * Created by Victoria on 04.01.2018.
 */
public class DiscountService {
    private DiscountDAO discountDAO;

    public DiscountService() {
        discountDAO = new DiscountDAOImpl();
    }

    /**
     * This method get discount for client sum from db
     *
     * @param client
     * @return discount if there is discount for client sum, otherwise <code>null</code>
     */
    public Discount getDiscountForClient(Client client) {
        return discountDAO.getDiscountOnSum(client.getSum());
    }
}
