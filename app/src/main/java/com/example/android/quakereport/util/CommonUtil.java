package com.example.android.quakereport.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sprim on 04-10-2017.
 */

public class CommonUtil {

    public static String formatDate(Date dateObj) {
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat("LLL dd, yyyy");
        dateStr = sdf.format(dateObj);
        return dateStr;
    }

    public static String formatTime(Date dateObj) {
        String timeStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        timeStr = sdf.format(dateObj);
        return timeStr;
    }

    public static String getPlace(String location){
        String place = "";
        if(location.contains("of")){
            String[] locationSplit = location.split("of");
            place = locationSplit[0] + " of";
        } else {
            place = "Near the";
        }
        return place;
    }

    public static String getCity(String location){
        String city = "";
        if(location.contains("of")){
            String[] locationSplit = location.split("of");
            city = locationSplit[1];
        } else {
            city = "Pacific-Antarctic Ridge";
        }
        return city;
    }
}
