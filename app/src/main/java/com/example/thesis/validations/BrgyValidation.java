package com.example.thesis.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.thesis.R;

public class BrgyValidation extends Validation{
    
    private final String[] VALID_BRGYS = context.getResources().getStringArray(R.array.valid_brgys);

    public BrgyValidation(Context context, EditText editText) {
        super(context, editText);
    }


    @Override
    public boolean isValid(String brgyNameToCheck){
        if(TextUtils.isEmpty(brgyNameToCheck.trim())){
            errorMessage = "Brgy. is required!";
            return false;
        }

        for(String thisCity : VALID_BRGYS) {
            if(thisCity.toLowerCase().trim().equals(brgyNameToCheck.toLowerCase().trim())){
                return true;
            }
        }

        errorMessage = "Vaccines are not available in the brgy : " + brgyNameToCheck;
        return false;
    }
}
