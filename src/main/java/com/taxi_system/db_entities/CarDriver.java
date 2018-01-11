package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 22.12.2017.
 */
public class CarDriver implements Serializable {
    protected int id;
    protected String name;
    protected String phoneNumber;

    public CarDriver(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String carDriverInfo() {
        StringBuilder result = new StringBuilder();
        result.append("com.taxi_system.db_entities.car_driver: ");
        result.append("id = ").append(id);
        result.append(", name = ").append(name);
        result.append(", phone number = ").append(phoneNumber);
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDriver carDriver = (CarDriver) o;

        return id == carDriver.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("car driver name = ").append(name);
        result.append(", phone number = ").append(phoneNumber);
        return result.toString();
    }
}
