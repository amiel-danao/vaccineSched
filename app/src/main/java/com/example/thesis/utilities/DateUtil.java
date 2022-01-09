package com.example.thesis.utilities;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.R;
import com.example.thesis.activities.EditProfileActivity;
import com.example.thesis.validations.DateValidation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String dateToString(Date date, String format){
        if(date == null){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
        return simpleDateFormat.format(date);
    }
}
