package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.regex.Pattern;

public class NameValidation extends Validation {

    private final String REGEX_PATTERN = "[A-Za-z ]*";

    public NameValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "invalid name!";
    }


    @Override
    public boolean isValid(String nameToCheck) {
        if(TextUtils.isEmpty(nameToCheck.trim())){
            return false;
        }

        return Pattern.compile(REGEX_PATTERN)
                .matcher(nameToCheck.trim())
                .matches();
    }
}
