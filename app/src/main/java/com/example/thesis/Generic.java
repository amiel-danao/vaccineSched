package com.example.thesis;

import android.text.TextUtils;

public class Generic{
  
    public static final String USER_LOGGED_IN_TAG = "userLoggedIn";
    
    public static boolean hasEmptyOrNullString(String[] strings){
        for(String thisString : strings) {
            if(thisString == null || TextUtils.isEmpty(thisString.trim())){
                return true;
            }
        }
        return false;
    }
}
