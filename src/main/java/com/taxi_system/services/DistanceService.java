package com.taxi_system.services;

/**
 * Created by Victoria on 04.01.2018.
 */
public class DistanceService {
    public float calculateDistance(String fromAddress, String toAddress) {
        float result = (float) (toAddress.hashCode() - fromAddress.hashCode()) / 10;
        if (result < 0) result = -result;
        return result;
    }
}
