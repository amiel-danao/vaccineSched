package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

public class PhoneNumberValidation extends Validation{
    
    private final int PHONE_MAX_LENGTH = 11;

    public PhoneNumberValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
    }

    public PhoneNumberValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "Invalid phone number";
    }

    @Override
    public boolean isValid(String phoneNumberToCheck){
        if(TextUtils.isEmpty(phoneNumberToCheck.trim())){
            return false;
        }

        if(phoneNumberToCheck.length() == PHONE_MAX_LENGTH){
            return true;
        }

        return false;
    }
}
