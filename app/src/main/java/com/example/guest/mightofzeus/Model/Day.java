package com.example.guest.mightofzeus.Model;

/**
 * Created by Guest on 11/30/16.
 */
public class Day {
    private double mTemp;
    private String mWeather;

    public Day(double temp, String weather) {
        this.mTemp = temp;
        this.mWeather = weather;
    }

    public double getTemp() {
        return mTemp;
    }

    public String getWeather() {
        return mWeather;
    }
}
