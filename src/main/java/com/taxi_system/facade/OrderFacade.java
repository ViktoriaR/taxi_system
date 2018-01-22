package com.taxi_system.facade;

import com.taxi_system.db_entities.*;
import com.taxi_system.services.*;

/**
 * Created by Victoria on 12.01.2018.
 */
public class OrderFacade {
    public static Orders addPriceToOrder(Orders order, String clientLogin) {
        ClientService clientService = new ClientService();
        DistanceService distanceService = new DistanceService();
        DiscountService discountService = new DiscountService();
        StockService stockService = new StockService();
        CarTypeService carTypeService = new CarTypeService();

        Client client = clientService.getClient(clientLogin);
        float distance = distanceService.calculateDistance(order.getFromAddress(), order.getToAddress());
        Discount discount = discountService.getDiscountForClient(client);
        Stock stock = stockService.getCurrentStock();
        CarType carType = carTypeService.getCarTypeByName(order.getCarType());

        order.setDistance(distance).setDiscount(discount).setStock(stock);
        float price = distance * carType.getCoefficient() * 7;
        order.setPrice(price);
        order.setClient(client);

        return order;
    }
}
