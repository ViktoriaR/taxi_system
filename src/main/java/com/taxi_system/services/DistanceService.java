package com.taxi_system.services;

/**
 * Created by Victoria on 04.01.2018.
 */
public class DistanceService {
    public float calculateDistance(String fromAddress, String toAddress) {
        float result = Math.abs( toAddress.hashCode() - fromAddress.hashCode()) % 100;
        return result;
    }
}
