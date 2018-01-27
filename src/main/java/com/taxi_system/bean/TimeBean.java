package com.taxi_system.bean;

import com.taxi_system.db_entities.Orders;

import java.sql.Timestamp;
import java.time.LocalTime;

/**
 * Created by Victoria on 27.01.2018.
 */
public class TimeBean {
    private long hoursLeft;
    private long minutesLeft;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MILLIS_PER_SECOND = 1000;

    public TimeBean() {
    }

    public void setLeftTime(Timestamp compareTime) {
        long seconds = (compareTime.getTime() - new Timestamp(System.currentTimeMillis()).getTime()) / MILLIS_PER_SECOND;
        if (seconds <= 0) {
            hoursLeft = 0;
            minutesLeft = 0;
        } else {
            hoursLeft = seconds / SECONDS_PER_HOUR;
            minutesLeft = (seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
        }
    }

    public long getLeftHours() {
        return this.hoursLeft;
    }

    public long getLeftMinutes() {
        return this.minutesLeft;
    }
}
