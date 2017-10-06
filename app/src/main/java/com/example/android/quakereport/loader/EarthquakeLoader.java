package com.example.android.quakereport.loader;

import android.content.Context;

import com.example.android.quakereport.QueryUtils;
import com.example.android.quakereport.model.Earthquake;

import java.util.List;

import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

/**
 * Created by Sprim on 05-10-2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader <List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        Log.i(LOG_TAG, "EarthquakeLoader constructor");
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "onStartLoading");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG, "loadInBackground");
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
