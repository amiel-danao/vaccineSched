package com.example.thesis.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.models.Schedule;
import com.example.thesis.models.User;
import com.example.thesis.utilities.DateUtil;
import com.example.thesis.utilities.Generic;
import com.example.thesis.R;
import com.example.thesis.utilities.Urls;
import com.example.thesis.models.Vaccine;
import com.example.thesis.validations.BirthDayValidation;
import com.example.thesis.validations.BrgyValidation;
import com.example.thesis.validations.CityValidation;
import com.example.thesis.validations.DateValidation;
import com.example.thesis.validations.LastNameValidation;
import com.example.thesis.validations.NameValidation;
import com.example.thesis.validations.PhoneNumberValidation;
import com.example.thesis.validations.StringValidation;
import com.example.thesis.validations.Validation;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AuthenticatedActivity {
    private ImageButton backButton;
    private Button confirmButton;
    private Button changePasswordButton;
    private TextView txtEditProfileTitle;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editBirthday;
    private EditText editBirthPlace;
    private EditText editCity;
    private EditText editBrgy;
    private EditText editBrgyId;
    private EditText editSex;
    private EditText editWeight;
    private EditText editHeight;
    private EditText editPhone;
    private EditText editMothersName;
    private EditText editFathersName;
    private ArrayList<Validation> fieldsToValidate;
    private Context context;
    private ProgressDialog progressDialog;
    private ArrayList<Validation> vaccineFieldsToValidate;

    private Vaccine selectedVaccine;
    private Schedule selectedSchedule;
    private User origUserBeforeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        if(isFinishing()){
            return;
        }

        try {
            origUserBeforeEdit = (User) currentUser.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return;
        }

        context = getApplicationContext();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            selectedVaccine = (Vaccine)bundle.getSerializable(Generic.SELECTED_VACCINE_TAG);
            selectedSchedule = (Schedule) bundle.getSerializable(Generic.SELECTED_SCHEDULE);
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);

        getViews();
        addValidations();
        fillUserInfo();
        addVaccineRequiredValidations();

        dateValidationSetup();

        setFormTitle();

        setClickListeners();
    }

    private void setClickListeners() {
        backButton = (ImageButton) findViewById(R.id.imgBtnBack);
        backButton.setOnClickListener(v -> gotoActivity(EditProfileActivity.this, HomeActivity.class));

        confirmButton = findViewById(R.id.btnConfirm);
        confirmButton.setOnClickListener(view -> {
            if(isFormValid()) {
                updateCurrentUserFields();
            }
        });

        // TODO: Add/Remove change password validation
        changePasswordButton.setOnClickListener(v -> {
            Intent intent = new Intent(EditProfileActivity.this, ChangePassword.class);
            startActivity(intent);
        });
    }

    private void updateCurrentUserFields(){
        progressDialog.show();
        currentUser.setFirstname(editTextFirstName.getText().toString());
        currentUser.setLastname(editTextLastName.getText().toString());

        String birthdayText = editBirthday.getText().toString();
        if(!birthdayText.isEmpty()) {
            try {
                Instant instant = Instant.parse(birthdayText + context.getResources().getString(R.string.instant_zero_time));
                ZoneId zoneId = ZoneId.of(context.getResources().getString(R.string.used_time_zone));
                ZonedDateTime zonedDateTime = instant.atZone(zoneId);
                Calendar calendar = Calendar.getInstance();
                calendar.set(zonedDateTime.getYear(), zonedDateTime.getMonthValue(), zonedDateTime.getDayOfMonth());
                currentUser.setDateofbirth(calendar.getTime());
            }
            catch(DateTimeParseException dateTimeParseException){
                message(getString(R.string.error_invalid_date));
                revertSavedUserFields();
                progressDialog.dismiss();
                return;
            }
        }

        currentUser.setPlaceofbirth(editBirthPlace.getText().toString());
        currentUser.setCity(editCity.getText().toString());
        currentUser.setBaranggay(editBrgy.getText().toString());
        currentUser.setSex(editSex.getText().toString());
        currentUser.setBirthweight(Float.parseFloat(editWeight.getText().toString()));
        currentUser.setBirthheight(Float.parseFloat(editHeight.getText().toString()));
        currentUser.setPhone(editPhone.getText().toString());
        currentUser.setMothersname(editMothersName.getText().toString());
        currentUser.setFathersname(editFathersName.getText().toString());

        saveUpdatedInfo();
    }

    private void revertSavedUserFields(){
        if(origUserBeforeEdit != null){
            return;
        }

        try {
            currentUser = (User) origUserBeforeEdit.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void saveUpdatedInfo() {

        String url = Urls.UPDATE_USER;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            if(response.equals(getString(R.string.response_user_updated_successfully))) {
                if (selectedVaccine != null && selectedSchedule != null) {
                    gotoAppointmentConfirmation();
                } else {
                    gotoActivity(EditProfileActivity.this, HomeActivity.class);
                }
            }
            else{
                revertSavedUserFields();
            }

            message(response);

            progressDialog.hide();

        }, error -> {

            if (error instanceof TimeoutError) {
                message(getString(R.string.error_network_timeout));
            } else if (error instanceof NoConnectionError) {
                message(getString(R.string.error_network_no_connection));
            } else if (error instanceof AuthFailureError) {
                message(getString(R.string.error_network_auth));
            } else if (error instanceof ServerError) {
                message(getString(R.string.error_network_server));
            } else if (error instanceof NetworkError) {
                message(getString(R.string.error_network));
            } else if (error instanceof ParseError) {
                message(getString(R.string.error_parse));
            } else {
                message(getString(R.string.error_status));
            }

            progressDialog.dismiss();
        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                Map <String,String> params = new HashMap<>();
                params.put("user_id", String.valueOf(currentUser.getUser_id()));

                params.put("firstname", currentUser.getFirstname());
                params.put("lastname", currentUser.getLastname());
                if(!editBirthday.getText().toString().isEmpty()) {
                    params.put("birthday", editBirthday.getText().toString());
                }
                params.put("birthplace", currentUser.getPlaceofbirth());
                params.put("city", currentUser.getCity());
                params.put("brgy", currentUser.getBaranggay());
                params.put("sex", currentUser.getSex());
                params.put("weight", String.valueOf(currentUser.getBirthweight()));
                params.put("height", String.valueOf(currentUser.getBirthheight()));
                params.put("phone" ,currentUser.getPhone());
                params.put("mothersname", currentUser.getMothersname());
                params.put("fathersname", currentUser.getFathersname());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditProfileActivity.this);
        requestQueue.add(request);
    }

    private void gotoAppointmentConfirmation() {
        Intent intent = new Intent(EditProfileActivity.this, AppointmentConfirmationActivity.class);
        intent.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
        intent.putExtra(Generic.SELECTED_SCHEDULE, selectedSchedule);
        intent.putExtra(Generic.SELECTED_VACCINE_TAG, selectedVaccine);
        startActivity(intent);
    }

    private void setFormTitle() {
        if(selectedVaccine != null){
            txtEditProfileTitle.setText(R.string.vaccine_fill_up_title);
        }
        else{
            txtEditProfileTitle.setText(R.string.edit_profile_title);
        }
    }

    private void dateValidationSetup() {
        final ArrayList<DateValidation> dateValidations = getDateValidationFields();
        if(!dateValidations.isEmpty()){
            progressDialog.show();
            String url = Urls.GET_SERVER_DATE;

            StringRequest request = new StringRequest(Request.Method.GET, url, response -> {

                for(DateValidation dateValidation : dateValidations){
                    dateValidation.setServerDate(response);
                }
                progressDialog.dismiss();
            }, error -> {
                progressDialog.dismiss();
            });

            RequestQueue requestQueue = Volley.newRequestQueue(EditProfileActivity.this);
            requestQueue.add(request);
        }
    }

    private ArrayList<DateValidation> getDateValidationFields(){
        ArrayList<DateValidation> toReturn = new ArrayList<>();
        ArrayList<Validation> allValidations = new ArrayList<>();
        allValidations.addAll(fieldsToValidate);
        allValidations.addAll(vaccineFieldsToValidate);

        for(Validation validation : allValidations){
            if(validation instanceof DateValidation){
                toReturn.add((DateValidation)validation);
            }
        }

        return toReturn;
    }

    private void addVaccineRequiredValidations() {
        vaccineFieldsToValidate = new ArrayList<>(Arrays.asList(
                new BirthDayValidation(EditProfileActivity.this, editBirthday),
                new StringValidation(EditProfileActivity.this, editBirthPlace),
                new StringValidation(EditProfileActivity.this, editSex)
        ));

        if(selectedVaccine != null){
            fieldsToValidate.addAll(vaccineFieldsToValidate);
            changePasswordButton.setVisibility(View.GONE);
        }
        else{
            changePasswordButton.setVisibility(View.VISIBLE);
        }
    }

    private void addValidations() {
        fieldsToValidate = new ArrayList<>(Arrays.asList(
                new CityValidation(context, editCity),
                new BrgyValidation(context, editBrgy),
                new PhoneNumberValidation(context, editPhone)));
    }

    private boolean isFormValid(){
        for(Validation validation : fieldsToValidate){
            if(!validation.isValid()){
                validation.showError();
                message(validation.getErrorMessage());
                return false;
            }
        }

        return true;
    }

    private void getViews() {
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editBirthday = findViewById(R.id.editBday);
        editBirthPlace = findViewById(R.id.editBirthPlace);
        editCity = findViewById(R.id.editCity);
        editBrgy = findViewById(R.id.editBrgy);
        editBrgyId = findViewById(R.id.editCardId);
        editSex = findViewById(R.id.editSex);
        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        editPhone = findViewById(R.id.editPhone);
        editMothersName = findViewById(R.id.editMothersName);
        editFathersName = findViewById(R.id.editFathersName);
        txtEditProfileTitle = findViewById(R.id.txtEditProfileTitle);
        changePasswordButton = findViewById(R.id.changePassButton);

    }

    private void fillUserInfo() {
        editTextFirstName.setText(currentUser.getFirstname());
        editTextLastName.setText(currentUser.getLastname());
        editBirthday.setText(DateUtil.dateToString(currentUser.getDateofbirth(), context.getResources().getString(R.string.simple_date_format)));
        editBirthPlace.setText(currentUser.getPlaceofbirth());
        editCity.setText(currentUser.getCity());
        editBrgy.setText(currentUser.getBaranggay());
        editBrgyId.setText(currentUser.getBrgyId());
        editSex.setText(currentUser.getSex());
        editWeight.setText(String.valueOf(currentUser.getBirthweight()));
        editHeight.setText(String.valueOf(currentUser.getBirthheight()));
        editPhone.setText(String.valueOf(currentUser.getStringPhone()));
        editMothersName.setText(currentUser.getMothersname());
        editFathersName.setText(currentUser.getFathersname());
    }

    public void message(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
