package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 22.12.2017.
 */
public class CarDriver implements Serializable {
    private long id;
    private String name;
    private String phoneNumber;

    public CarDriver(long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("car driver name = ").append(name);
        result.append(", phone number = ").append(phoneNumber);
        return result.toString();
    }
}
