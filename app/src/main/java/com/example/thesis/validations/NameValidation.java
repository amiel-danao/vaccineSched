package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.thesis.R;

import java.util.regex.Pattern;

public class NameValidation extends Validation {


    private final String[] VALID_NAMES= context.getResources().getStringArray(R.array.valid_names);


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

        /*for(String thisName : VALID_NAMES ) {
            if(thisName.toLowerCase().trim().equals(nameToCheck.toLowerCase().trim())){
                return true;
            }
        }
        errorMessage = "Only residents of Salawag can register, Contact the Baranggay for further Questions.";*/
        return true;




    }
}
