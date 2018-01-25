package com.taxi_system.facade;

import com.taxi_system.db_connection.ConnectionPool;
import com.taxi_system.db_entities.*;
import com.taxi_system.services.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Victoria on 12.01.2018.
 */
public class OrderFacade {

    public static final int PRICE_PER_KM = 7;

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
        float price = distance * carType.getCoefficient() * PRICE_PER_KM;
        order.setPrice(price);
        order.setClient(client);

        return order;
    }

    public static Orders processOrder(Orders order) throws Exception {
        Connection connection = null;
        CarService carService = new CarService();
        OrdersService ordersService = new OrdersService();
        ClientService clientService = new ClientService();
        Client client = order.getClient();
        float sum = client.getSum();
        DistanceService distanceService = new DistanceService();

        try {
            try {
                connection = ConnectionPool.getInstance().getConnection();
                connection.setAutoCommit(false);

                List<Car> cars = carService.findAvailableCars(order.getCarType());
                if (cars.isEmpty()) throw new Exception("no available car, try again later");
                order.setCar(cars.get(0));

                Timestamp expectedBoardingTime = distanceService.calculateTime(order.getCar().getLocation(), order.getFromAddress());
                order.setExpectedBoardingTime(expectedBoardingTime);

                ordersService.createOrderInDB(connection, order);

                order.getCar().setAvailable(false);
                carService.updateCarInDB(connection, order.getCar());

                client.setSum(sum + order.getPrice());
                clientService.updateClientInDB(connection, client);

                connection.commit();
            } catch (SQLException e) {
                if (connection != null) {
                    client.setSum(sum);
                    connection.rollback();
                }
                throw new Exception("something wrong, try again later");
            } finally {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}
