package com.example.guest.mightofzeus.Services;

import com.example.guest.mightofzeus.Constants;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Created by Guest on 11/30/16.
 */
public class CloudService {

    public static void findWeather(String cityId, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.ID_QUERY_PARAMETER, cityId);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url =urlBuilder.build().toString();
    }
}
