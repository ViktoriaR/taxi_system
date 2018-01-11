package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Car implements Serializable {
    private int id;
    private Integer carTypeId;
    private Integer carDriverId;
    private String model;
    private String number;
    private boolean available;
    private String location;

    public Car(int id, Integer carTypeId, Integer carDriverId, String model, String number, boolean available, String location) {
        this.id = id;
        this.carTypeId = carTypeId;
        this.carDriverId = carDriverId;
        this.model = model;
        this.number = number;
        this.available = available;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Integer getCarTypeId() {
        return carTypeId;
    }

    public Integer getCarDriverId() {
        return carDriverId;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLocation() {
        return location;
    }

    public String carInfo() {
        StringBuilder result = new StringBuilder();
        result.append("com.taxi_system.db_entities.car: ");
        result.append("id = ").append(id);
        result.append(", car number = ").append(number);
        result.append(", car model = ").append(model);
        result.append(", ").append(carTypeId);
        result.append(", ").append(carDriverId);
        result.append(", available =  ").append(available);
        result.append(", location =  ").append(location);
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return number != null ? number.equals(car.number) : car.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Car number = ").append(number);
        result.append(", car model = ").append(model);
        return result.toString();
    }
}
