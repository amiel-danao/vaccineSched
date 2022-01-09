package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

public class StringValidation extends Validation {

    public StringValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
    }

    public StringValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "invalid data!";
    }

    @Override
    public boolean isValid(String nameToCheck) {
        return !TextUtils.isEmpty(nameToCheck.trim());
    }
}