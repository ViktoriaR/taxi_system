package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Car implements Serializable {
    private long id;
    private CarType carType;
    private CarDriver carDriver;
    private String model;
    private String number;
    private boolean available;
    private String location;

    public Car(long id, CarType carType, CarDriver carDriver, String model, String number, boolean available, String location) {
        this.id = id;
        this.carType = carType;
        this.carDriver = carDriver;
        this.model = model;
        this.number = number;
        this.available = available;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public CarType getCarType() {
        return carType;
    }

    public CarDriver getCarDriver() {
        return carDriver;
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
