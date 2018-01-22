package com.taxi_system.db_entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Victoria on 23.12.2017.
 */
public class Stock implements Serializable {
    private long id;
    private byte percent;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;

    public Stock(long id, byte percent, Timestamp startDate, Timestamp endDate, String description) {
        this.id = id;
        this.percent = percent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public byte getPercent() {
        return percent;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String stockInfo() {
        StringBuilder result = new StringBuilder();
        result.append("com.taxi_system.db_entities.stock: ");
        result.append("id = ").append(id);
        result.append(", percent = ").append(percent);
        result.append(", description = ").append(description).append(".");
        return result.toString();
    }

    @Override
    public String toString() {
        return "stock: " + description;
    }
}
