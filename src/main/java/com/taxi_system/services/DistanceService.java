package com.taxi_system.services;

import java.sql.Timestamp;

/**
 * Created by Victoria on 04.01.2018.
 */
public class DistanceService {
    private static final int MAX_DISTANCE = 100;
    private static final float AVERAGE_SPEED_KM_PER_HOUR = 50;
    private static final long MILLIS_PER_HOUR = 3_600_000;

    public float calculateDistance(String fromAddress, String toAddress) {
        float result = Math.abs(toAddress.hashCode() - fromAddress.hashCode()) % MAX_DISTANCE;
        return result;
    }

    public Timestamp calculateTime(String fromAddress, String toAddress) {
        float distance = calculateDistance(fromAddress, toAddress);
        return new Timestamp(System.currentTimeMillis() + (long) (distance / AVERAGE_SPEED_KM_PER_HOUR * MILLIS_PER_HOUR));
    }
}
