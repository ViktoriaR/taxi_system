package com.taxi_system.db_entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Orders implements Serializable {
    private int id;
    private Integer clientId;
    private Integer carId;
    private Integer discountId;
    private Integer stockId;
    private Timestamp arrivalTime;
    private String fromAddress;
    private String toAddress;
    private float distance;
    private float price;

    public Orders() {
    }

    public Orders(int clientId, String fromAddress, String toAddress) {
        this.clientId = clientId;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public int getId() {
        return id;
    }

    public Orders id(int id) {
        this.id = id;
        return this;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Orders clientId(Integer clientId) {
        this.clientId = clientId;
        return this;
    }

    public Integer getCarId() {
        return carId;
    }

    public Orders carId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public Orders discountId(Integer discountId) {
        this.discountId = discountId;
        return this;
    }

    public Integer getStockId() {
        return stockId;
    }

    public Orders stockId(Integer stockId) {
        this.stockId = stockId;
        return this;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public Orders arrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public Orders fromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        return this;
    }

    public String getToAddress() {
        return toAddress;
    }

    public Orders toAddress(String toAddress) {
        this.toAddress = toAddress;
        return this;
    }

    public float getDistance() {
        return distance;
    }

    public Orders distance(float distance) {
        this.distance = distance;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Orders price(float price) {
        this.price = price;
        return this;
    }
}
