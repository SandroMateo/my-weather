package com.example.guest.mightofzeus.Services;

import com.example.guest.mightofzeus.Constants;
import com.example.guest.mightofzeus.Model.Day;
import com.example.guest.mightofzeus.Model.Zeus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 11/30/16.
 */
public class CloudService {

    public static void findWeather(String zip, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.ZIP_QUERY_PARAMETER, zip);
        urlBuilder.addQueryParameter(Constants.DAYS_QUERY_PARAMETER, Constants.DAYS);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url =urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Day> processResults(Response response) {
        ArrayList<Day> forecast = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                String city = weatherJSON.getJSONObject("city").getString("name");
                double lon = weatherJSON.getJSONObject("city").getJSONObject("coord").getDouble("lon");
                double lat = weatherJSON.getJSONObject("city").getJSONObject("coord").getDouble("lat");
                String country = weatherJSON.getJSONObject("city").getString("country");
                JSONArray list = weatherJSON.getJSONArray("list");
                for(int i = 0; i < list.length(); i++) {
                    double temp = list.getJSONObject(i).getJSONObject("temp").getDouble("day");
                    String weather = list.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                    Day day = new Day(temp, weather);
                    forecast.add(day);
                }
//                thunderBolt = new Zeus(city, country, forecast, lon, lat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return forecast;
    }
}
