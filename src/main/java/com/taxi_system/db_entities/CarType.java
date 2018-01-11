package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 22.12.2017.
 */
public class CarType implements Serializable {
    protected int id;
    protected String type;
    protected String description;
    protected float coefficient;

    public CarType(int id, String type, String description, float coefficient) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.coefficient = coefficient;
    }

    public int getId() {
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

    public String carTypeInfo() {
        StringBuilder result = new StringBuilder();
        result.append("com.taxi_system.db_entities.car_type: ");
        result.append("id = ").append(id);
        result.append(", type = ").append(type);
        result.append(", description =  ").append(description);
        return result.toString();
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
