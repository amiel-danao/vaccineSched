package com.example.thesis;

import android.text.TextUtils;

public static class Generic{
  
    public final String USER_LOGGED_IN_TAG = "userLoggedIn";
    
    public boolean hasEmptyOrNullString(String[] strings){
        for(String thisString : strings) {
            if(thisString == null || TextUtils.isEmpty(thisString.trim())){
                return true;
            }
        }
    }
}
