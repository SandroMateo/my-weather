package com.example.guest.mightofzeus.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.guest.mightofzeus.Model.Day;
import com.example.guest.mightofzeus.Model.Zeus;
import com.example.guest.mightofzeus.R;
import com.example.guest.mightofzeus.Services.CloudService;
import com.example.guest.mightofzeus.adapters.ForecastListAdapter;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ZeusFuryActivity extends AppCompatActivity {
    public static final String TAG = ZeusFuryActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ForecastListAdapter mAdapter;

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
            public void onResponse(Call call, Response response) {
                Log.d("Log", response.toString());
                mForecast = cloudService.processResults(response);

                ZeusFuryActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new ForecastListAdapter(getApplicationContext(), mForecast);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ZeusFuryActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });

            }
        });
    }
}
