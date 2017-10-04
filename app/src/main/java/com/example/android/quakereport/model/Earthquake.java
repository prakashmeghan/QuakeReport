package com.example.android.quakereport.model;

/**
 * Created by Sprim on 04-10-2017.
 */

public class Earthquake {
    private double mag;
    private String place;
    private String quakeDate;

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

    public String getQuakeDate() {
        return quakeDate;
    }

    public void setQuakeDate(String quakeDate) {
        this.quakeDate = quakeDate;
    }
}
