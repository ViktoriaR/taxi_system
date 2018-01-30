package com.taxi_system.services;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;

public class DistanceServiceTest {

    private String pointA = "testpointA";
    private String pointB = "pointBtesu";

    private DistanceService distanceService = new DistanceService();

    @Test
    public void calculateDistance() {
        Assert.assertEquals("Unexpected calculation result", 50, distanceService.calculateDistance(pointA, pointB), 0f);
    }

    @Test
    public void calculateTime() {
        long expected = new Timestamp(System.currentTimeMillis() + 3_600_000).getTime();
        long actual = distanceService.calculateTime(pointA, pointB).getTime();
        Assert.assertEquals("Unexpected calculation result", expected, actual, (long)5000);
    }
}