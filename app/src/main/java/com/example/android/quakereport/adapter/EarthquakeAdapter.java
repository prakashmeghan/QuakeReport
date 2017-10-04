package com.example.android.quakereport.adapter;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.model.Earthquake;
import com.example.android.quakereport.util.CommonUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sprim on 04-10-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> alEarthquake) {
        super(context, 0, alEarthquake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);
        TextView tvMag = (TextView) listItemView.findViewById(R.id.tv_mag);
        TextView tvPlace = (TextView) listItemView.findViewById(R.id.tv_place);
        TextView tvCity = (TextView) listItemView.findViewById(R.id.tv_city);
        TextView tvDate = (TextView) listItemView.findViewById(R.id.tv_date);
        TextView tvTime = (TextView) listItemView.findViewById(R.id.tv_time);

        DecimalFormat df = new DecimalFormat("0.0");

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) tvMag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        tvMag.setText(df.format(earthquake.getMag()));
        tvPlace.setText(CommonUtil.getPlace(earthquake.getPlace()));
        tvCity.setText(CommonUtil.getCity(earthquake.getPlace()));

        Date dateObj = new Date(earthquake.getQuaketime());

        String dateStr = CommonUtil.formatDate(dateObj);
        String timeStr = CommonUtil.formatTime(dateObj);

        tvDate.setText(dateStr);
        tvTime.setText(timeStr);
        return listItemView;
    }

    private int getMagnitudeColor(double mag) {
        int magnitude1Color = 0;
        if(mag < 2.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        } else if(mag >= 2.0  && mag < 3.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
        } else if(mag >= 3.0  && mag < 4.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
        }else if(mag >= 4.0  && mag < 5.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
        }else if(mag >= 5.0  && mag < 6.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
        }else if(mag >= 6.0  && mag < 7.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
        }else if(mag >= 7.0  && mag < 8.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
        }else if(mag >= 8.0  && mag < 9.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
        }else if(mag >= 9.0  && mag < 10.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
        }else if(mag > 10.0){
            magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }


        return magnitude1Color;
    }
}
