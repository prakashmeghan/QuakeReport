package com.example.android.quakereport.model;

/**
 * Created by Sprim on 04-10-2017.
 */

public class Earthquake {
    private double mag;
    private String place;
    private long quakeTime;
    private String quakeUrl;

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getQuaketime() {
        return quakeTime;
    }

    public void setQuakeTime(long quakeTime) {
        this.quakeTime = quakeTime;
    }

    public String getQuakeUrl() {
        return quakeUrl;
    }

    public void setQuakeUrl(String quakeUrl) {
        this.quakeUrl = quakeUrl;
    }
}
