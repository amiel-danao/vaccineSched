package com.example.thesis.validations;


import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.thesis.R;

public class LastNameValidation extends Validation{

    private final String[] VALID_LASTNAMES= context.getResources().getStringArray(R.array.valid_lastname);

    public LastNameValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
    }

    public LastNameValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "invalid name!";
    }

    @Override
    public boolean isValid(String lastnameToCheck) {
        if(TextUtils.isEmpty(lastnameToCheck.trim())){
            return false;
        }
        return true;



    }
}
