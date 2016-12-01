package com.example.guest.mightofzeus.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.mightofzeus.Model.Day;
import com.example.guest.mightofzeus.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 11/30/16.
 */
public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>{

    private ArrayList<Day> mForecasts = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context context, ArrayList<Day> Forecasts) {
        mContext = context;
        mForecasts = Forecasts;
    }


    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zeus_fury_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }


    public class ForecastViewHolder extends RecyclerView.ViewHolder {
//        @Bind(R.id.ForecastImageView) ImageView mForecastImageView;
        @Bind(R.id.cityNameTextView) TextView mNameTextView;
        @Bind(R.id.temperatureTextView) TextView mTemperatureTextView;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindForecast(Day day) {
            mNameTextView.setText(day.getWeather());
            mTemperatureTextView.setText(Double.toString(day.getTemp()));
        }
    }
    
}
