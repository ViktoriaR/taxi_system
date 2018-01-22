package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Discount implements Serializable {
    private long id;
    private byte percent;
    private float bottomSum;
    private float upperSum;
    private String description;

    public Discount(long id, byte percent, long bottomSum, long upperSum, String description) {
        this.id = id;
        this.percent = percent;
        this.bottomSum = bottomSum;
        this.upperSum = upperSum;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public byte getPercent() {
        return percent;
    }

    public float getBottomSum() {
        return bottomSum;
    }

    public float getUpperSum() {
        return upperSum;
    }

    public String getDescription() {
        return description;
    }

    public String discountInfo() {
        StringBuilder result = new StringBuilder();
        result.append("com.taxi_system.db_entities.discount: ");
        result.append("id = ").append(id);
        result.append(", percent = ").append(percent);
        result.append(", description = ").append(description).append(".");
        return result.toString();
    }

    @Override
    public String toString() {
        return "discount: " + description;
    }

}
