package com.example.thesis.models;

import android.content.Context;

import com.example.thesis.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Schedule implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("date")
    @Expose
    private Date date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("capacity")
    @Expose
    private int capacity;
    @SerializedName("nurse")
    @Expose
    private String nurse;
    @SerializedName("place")
    @Expose
    private String place;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getNurse() {
        return nurse;
    }

    public String getPlace() {
        return place;
    }

    public String getWordDateString(Context context) {
        String toReturn = "";

        if(date != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(context.getResources().getString(R.string.word_date_format), Locale.US);
            toReturn = simpleDateFormat.format(date);
        }

        return toReturn;
    }
}
