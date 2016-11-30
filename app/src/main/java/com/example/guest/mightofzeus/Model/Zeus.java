package com.example.guest.mightofzeus.Model;

/**
 * Created by Guest on 11/30/16.
 */
public class Zeus {
    private String mCity;
    private int mCityId;
    private String mCountry;
    private double mTemp;
    private int mHumidity;
    private String mWeather;
    private double mLon;
    private double mLat;

    public Zeus(String city, int cityId, String country, double temp, int humidity, String weather, double lon, double lat) {
        this.mCity = city;
        this.mCityId = cityId;
        this.mCountry = country;
        this.mTemp = temp;
        this.mHumidity = humidity;
        this.mWeather = weather;
        this.mLon = lon;
        this.mLat = lat;
    }

    public String getCity() {
        return mCity;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getWeather() {
        return mWeather;
    }

    public int getCityId() {
        return mCityId;
    }

    public int getmHumidity() {
        return mHumidity;
    }

    public double getTemp() {
        return mTemp;
    }

    public double getLongitude() {
        return mLon;
    }

    public double getLatitude() {
        return mLat;
    }
}
