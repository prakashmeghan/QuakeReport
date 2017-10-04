package com.example.android.quakereport.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.model.Earthquake;

import java.util.ArrayList;

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
        TextView tvDate = (TextView) listItemView.findViewById(R.id.tv_date);

        tvMag.setText(String.valueOf(earthquake.getMag()));
        tvPlace.setText(earthquake.getPlace());
        tvDate.setText(earthquake.getQuakeDate());
        return listItemView;
    }
}
