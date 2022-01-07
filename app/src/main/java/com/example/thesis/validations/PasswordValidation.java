package com.example.thesis.validations;

import android.content.Context;
import android.widget.EditText;

import java.util.regex.Pattern;

public class PasswordValidation extends Validation{

    private final String REGEX_PATTERN = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";

    public PasswordValidation(Context context, EditText editText) {
        super(context, editText);
        errorMessage = "Password must be : at least one upper/lower case alphabet, \n and at least one special character,\n 8 characters and at most 20 characters.";
    }

    @Override
    public boolean isValid(String passwordToCheck) {
        return Pattern.compile(REGEX_PATTERN)
                .matcher(passwordToCheck)
                .matches();
    }
}
