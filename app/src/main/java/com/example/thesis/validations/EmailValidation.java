package com.example.thesis.validations;

import android.content.Context;
import android.widget.EditText;

import java.util.regex.Pattern;

public class EmailValidation extends Validation{
    private final String REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "invalid email address!";
    }


    @Override
    public boolean isValid(String emailToCheck) {

        return Pattern.compile(REGEX_PATTERN)
                .matcher(emailToCheck)
                .matches();
    }
}
