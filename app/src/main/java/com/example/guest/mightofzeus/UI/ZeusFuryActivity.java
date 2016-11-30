package com.example.guest.mightofzeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guest.mightofzeus.Model.Day;
import com.example.guest.mightofzeus.Model.Zeus;
import com.example.guest.mightofzeus.Services.CloudService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ZeusFuryActivity extends AppCompatActivity {
    public static final String TAG = ZeusFuryActivity.class.getSimpleName();
    public ArrayList<Day> mForecast = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeus_fury);

        Intent intent = getIntent();
        String zipCode = intent.getStringExtra("zip");
        getWeather(zipCode);
    }

    private void getWeather(String zip) {
        final CloudService cloudService = new CloudService();
        cloudService.findWeather(zip, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if(response.isSuccessful()) {
                        Log.v(TAG, jsonData);
                        mForecast = cloudService.processResults(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
