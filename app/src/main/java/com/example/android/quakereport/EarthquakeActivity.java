/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.quakereport.adapter.EarthquakeAdapter;
import com.example.android.quakereport.model.Earthquake;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    ArrayList<Earthquake> earthquakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        earthquakes = QueryUtils.extractEarthquakes();

//        dummyData();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);

        earthquakeListView.setOnItemClickListener(this);
    }

    private void dummyData(){
        /*Earthquake earthquake1 = new Earthquake();
        earthquake1.setMag(7.9);
        earthquake1.setPlace("France");
        earthquake1.setQuakeTime(1454124312220);

        Earthquake earthquake2 = new Earthquake();
        earthquake2.setMag(4.9);
        earthquake2.setPlace("Japan");
        earthquake2.setQuakeTime(1454124312220);

        Earthquake earthquake3 = new Earthquake();
        earthquake3.setMag(3.6);
        earthquake3.setPlace("Thailand");
        earthquake3.setQuakeTime(1454124312220);

        Earthquake earthquake4 = new Earthquake();
        earthquake4.setMag(4.0);
        earthquake4.setPlace("Singapore");
        earthquake4.setQuakeTime(1454124312220);

        earthquakes.add(earthquake1);
        earthquakes.add(earthquake2);
        earthquakes.add(earthquake3);
        earthquakes.add(earthquake4);*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Earthquake earthquake = earthquakes.get(position);
        String quakeUrl = earthquake.getQuakeUrl();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(quakeUrl));
        startActivity(browserIntent);
    }
}
