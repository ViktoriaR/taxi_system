package com.taxi_system.services;

import java.sql.Timestamp;

/**
 * Created by Victoria on 04.01.2018.
 */
public class DistanceService {
    public float calculateDistance(String fromAddress, String toAddress) {
        float result = Math.abs(toAddress.hashCode() - fromAddress.hashCode()) % 100;
        return result;
    }

    public Timestamp calculateTime(String fromAddress, String toAddress) {
        float distance = calculateDistance(fromAddress, toAddress);
        return new Timestamp(System.currentTimeMillis() + (long)distance*72000);
    }
}
