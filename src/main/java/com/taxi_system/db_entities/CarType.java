package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 22.12.2017.
 */
public class CarType implements Serializable {
    private long id;
    private String type;
    private String description;
    private float coefficient;

    public CarType(long id, String type, String description, float coefficient) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.coefficient = coefficient;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public float getCoefficient() {
        return coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarType carType = (CarType) o;

        return type != null ? type.equals(carType.type) : carType.type == null;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "car type: " + type;
    }
}
