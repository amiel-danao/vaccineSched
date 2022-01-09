package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.thesis.R;

import java.util.regex.Pattern;

public class NameValidation extends Validation {

    public NameValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
    }

    public NameValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "invalid name!";
    }


    @Override
    public boolean isValid(String nameToCheck) {
        if(TextUtils.isEmpty(nameToCheck.trim())){
            return false;
        }

        return Pattern.compile(context.getResources().getString(R.string.regex_valid_name))
                .matcher(nameToCheck.trim())
                .matches();
    }
}
