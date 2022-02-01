package com.example.thesis.validations;

import android.content.Context;
import android.widget.EditText;
import com.example.thesis.R;
import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class BirthDayValidation extends DateValidation{

    public BirthDayValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
    }

    public BirthDayValidation(Context context, EditText editText) {
        super(context, editText);
    }

    @Override
    public boolean isValid(String stringDateToCheck) {

        try {
            Instant dateToCheck = Instant.parse(stringDateToCheck + context.getResources().getString(R.string.instant_zero_time));
            int minimumAge = context.getResources().getInteger(R.integer.minimum_age_for_vaccine);

            ZonedDateTime minimumDate = serverDate.minusYears(minimumAge);

            if (dateToCheck.isAfter(minimumDate.toInstant())) {
                errorMessage = context.getResources().getString(R.string.error_age_not_allowed, minimumAge);
                return false;
            }
        }
        catch (DateTimeParseException dateTimeParseException){
            return false;
        }

        return true;
    }
}
