package com.taxi_system.db_entities;

import java.io.Serializable;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Discount implements Serializable {
    private long id;
    private float percent;
    private float bottomSum;
    private float upperSum;
    private String description;

    public Discount(long id, float percent, long bottomSum, long upperSum, String description) {
        this.id = id;
        this.percent = percent;
        this.bottomSum = bottomSum;
        this.upperSum = upperSum;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public float getPercent() {
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

    @Override
    public String toString() {
        return "discount: " + description;
    }

}
