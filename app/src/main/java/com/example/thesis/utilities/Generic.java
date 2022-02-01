package com.example.thesis.utilities;

import android.text.TextUtils;

public class Generic{

    public static final String USER_LOGGED_IN_TAG = "userLoggedIn";
    public static final String SELECTED_VACCINE_TAG = "selectedVaccine";
    public static final String SELECTED_SCHEDULE = "selectedSchedule";
    public static final String INVALID_FIELD_MESSAGE = "invalidFieldMessage";
    public static final String TAG = "logTag";

    public static boolean hasEmptyOrNullString(String[] strings){
        for(String thisString : strings) {
            if(thisString == null || TextUtils.isEmpty(thisString.trim())){
                return true;
            }
        }
        return false;
    }
}
