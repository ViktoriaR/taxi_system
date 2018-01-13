package com.taxi_system.db_entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Orders implements Serializable {
    private int id;
    private Client client;
    private Car car;
    private Discount discount;
    private Stock stock;
    private Timestamp arrivalTime;
    private String fromAddress;
    private String toAddress;
    private float distance;
    private float price;

    public Orders() {
    }

    public Orders(Client client, String fromAddress, String toAddress) {
        this.client = client;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public int getId() {
        return id;
    }

    public Orders setId(int id) {
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

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public Orders setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public Orders setToAddress(String toAddress) {
        this.toAddress = toAddress;
        return this;
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
        return price - price * discount - price * stock;
    }
}
