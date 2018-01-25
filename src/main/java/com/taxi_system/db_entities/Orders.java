package com.taxi_system.db_entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Orders implements Serializable {
    private long id;
    private Client client;
    private Car car;
    private Discount discount;
    private Stock stock;
    private String fromAddress;
    private String toAddress;
    private float distance;
    private float price;
    private String carType;
    private Timestamp expectedBoardingTime;

    public Orders() {
    }

    public Orders(String fromAddress, String toAddress, String carType) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.carType = carType;
    }

    public long getId() {
        return id;
    }

    public Orders setId(long id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Orders setClient(Client client) {
        this.client = client;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Orders setCar(Car car) {
        this.car = car;
        return this;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Orders setDiscount(Discount discount) {
        this.discount = discount;
        return this;
    }

    public Stock getStock() {
        return stock;
    }

    public Orders setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public Orders setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        return this;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public float getDistance() {
        return distance;
    }

    public Orders setDistance(float distance) {
        this.distance = distance;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Orders setPrice(float price) {
        this.price = price;
        return this;
    }

    public float getAmount() {
        float discount = getDiscount() != null ? getDiscount().getPercent() : 0;
        float stock = getStock() != null ? getStock().getPercent() : 0;
        return price - price * discount / 100 - price * stock / 100;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Timestamp getExpectedBoardingTime() {
        return expectedBoardingTime;
    }

    public void setExpectedBoardingTime(Timestamp expectedBoardingTime) {
        this.expectedBoardingTime = expectedBoardingTime;
    }
}
