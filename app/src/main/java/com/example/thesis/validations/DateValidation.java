package com.example.thesis.validations;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.EditText;
import com.example.thesis.R;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Locale;

public class DateValidation extends Validation{

    protected ZonedDateTime serverDate;
    protected ZonedDateTime editDate;
    protected long minDate;
    protected long maxDate;
    protected final SimpleDateFormat simpleDateFormat;
    protected final Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    public DateValidation(Context context, String stringToCheck) {
        super(context, stringToCheck);
        simpleDateFormat = new SimpleDateFormat(context.getResources().getString(R.string.simple_date_format), Locale.US);
    }

    public DateValidation(Context context, EditText editText) {
        super(context, editText);

        errorMessage = context.getResources().getString(R.string.error_invalid_date);
        simpleDateFormat = new SimpleDateFormat(context.getResources().getString(R.string.simple_date_format), Locale.US);
        setUpDatePicker();
    }

    private void setUpDatePicker(){

        onDateSetListener = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            updateLabel();
        };

        editText.setOnClickListener(view -> {
                int year = myCalendar.get(Calendar.YEAR);
                int month = myCalendar.get(Calendar.MONTH);
                int day = myCalendar.get(Calendar.DAY_OF_MONTH);

                if(editDate != null){
                    year = editDate.getYear();
                    month = editDate.getMonthValue() - 1;
                    day = editDate.getDayOfMonth();
                }
                else if(serverDate != null){
                    year = serverDate.getYear();
                    month = serverDate.getMonthValue() - 1;
                    day = serverDate.getDayOfMonth();
                }

                DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener,
                        year,
                        month,
                        day
                );

                if(minDate > 0){
                    datePickerDialog.getDatePicker().setMinDate(minDate);
                }

                if(maxDate > 0){
                    datePickerDialog.getDatePicker().setMaxDate(maxDate);
                }
                datePickerDialog.show();
        });
    }

    private void updateLabel(){
        editText.setText(simpleDateFormat.format(myCalendar.getTime()));
    }

    public void setServerDate(String dateToSet){
        try {
            Instant instant = Instant.parse(dateToSet + context.getResources().getString(R.string.instant_zero_time));
            ZoneId z = ZoneId.of(context.getResources().getString(R.string.used_time_zone));
            serverDate = instant.atZone(z);
        }
        catch (DateTimeParseException ignored){

        }
    }

    @Override
    public boolean isValid(String toCheck) {
        return false;
    }
}
