package com.example.thesis.validations;

import android.content.Context;
import android.util.Log;

import com.example.thesis.R;
import com.example.thesis.models.User;
import com.example.thesis.utilities.DateUtil;
import java.util.ArrayList;
import java.util.Arrays;

public class UserValidator {
    private ArrayList<Validation> validations;
    private BirthDayValidation birthDayValidation;
    private String invalidMessage;

    public UserValidator(Context context, User user, String serverDate) {
        birthDayValidation = new BirthDayValidation(context, DateUtil.dateToString(user.getDateofbirth(),
                context.getResources().getString(R.string.simple_date_format)));

        birthDayValidation.setServerDate(serverDate);
        setupValidations(context, user);
    }

    private void setupValidations(Context context, User user){
        validations = new ArrayList<>(Arrays.asList(
                new NameValidation(context, user.getFirstname()),
                new NameValidation(context, user.getLastname()),
                birthDayValidation,
                new StringValidation(context, user.getPlaceofbirth()),
                new CityValidation(context, user.getCity()),
                new BrgyValidation(context, user.getBaranggay()),
                new StringValidation(context, user.getSex()),
                new PhoneNumberValidation(context, user.getPhone())
        ));
    }



    public boolean isUserValid(){
        for(Validation validation : validations){
            if(!validation.isValid()){
                invalidMessage = validation.errorMessage;
                return false;
            }
        }
        return true;
    }

    public String getInvalidMessage(){return invalidMessage;}
}
