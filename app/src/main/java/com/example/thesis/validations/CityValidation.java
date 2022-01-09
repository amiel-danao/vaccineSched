package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.thesis.R;

public class CityValidation extends Validation{

    private final String[] VALID_CITIES = context.getResources().getStringArray(R.array.valid_cities);

    public CityValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
    }

    public CityValidation(Context context, EditText editText) {
        super(context, editText);
    }

    @Override
    public boolean isValid(String cityNameToCheck){
        if(TextUtils.isEmpty(cityNameToCheck.trim())){
            errorMessage = "City is required!";
            return false;
        }

        for(String thisCity : VALID_CITIES) {
            if(thisCity.toLowerCase().trim().equals(cityNameToCheck.toLowerCase().trim())){
                return true;
            }
        }

        errorMessage = "Vaccines are not available in the city : " + cityNameToCheck;
        return false;
    }
}
