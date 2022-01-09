package com.example.thesis.validations;

import android.content.Context;
import android.widget.EditText;

import com.example.thesis.R;

import java.util.regex.Pattern;

public class EmailValidation extends Validation{

    public EmailValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "invalid email address!";
    }


    @Override
    public boolean isValid(String emailToCheck) {

        return Pattern.compile(context.getResources().getString(R.string.regex_valid_email))
                .matcher(emailToCheck)
                .matches();
    }
}
