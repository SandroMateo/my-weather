package com.example.guest.mightofzeus.Model;

import java.util.ArrayList;

/**
 * Created by Guest on 11/30/16.
 */
public class Zeus {
    private String mCity;
    private String mCountry;
    private ArrayList<Day> mForecast = new ArrayList<>();
    private double mLon;
    private double mLat;

    public Zeus(String city, String country, ArrayList<Day> forecast, double lon, double lat) {
        this.mCity = city;
        this.mCountry = country;
        this.mLon = lon;
        this.mLat = lat;
    }

    public String getCity() {
        return mCity;
    }

    public String getCountry() {
        return mCountry;
    }

    public ArrayList<Day> getForecast() {
        return mForecast;
    }

    public double getLongitude() {
        return mLon;
    }

    public double getLatitude() {
        return mLat;
    }
}
