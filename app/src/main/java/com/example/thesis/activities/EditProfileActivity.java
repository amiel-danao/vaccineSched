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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.utilities.Generic;
import com.example.thesis.R;
import com.example.thesis.utilities.Urls;
import com.example.thesis.models.Vaccine;
import com.example.thesis.validations.BirthDayValidation;
import com.example.thesis.validations.BrgyValidation;
import com.example.thesis.validations.CityValidation;
import com.example.thesis.validations.DateValidation;
import com.example.thesis.validations.NameValidation;
import com.example.thesis.validations.PhoneNumberValidation;
import com.example.thesis.validations.Validation;

import java.util.ArrayList;
import java.util.Arrays;

public class EditProfileActivity extends AuthenticatedActivity {
    private ImageButton backButton;
    private Button confirmButton;
    private Button changePasswordButton;
    private TextView txtEditProfileTitle;
    private Vaccine selectedVaccine;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editBirthday;
    private EditText editBirthPlace;
    private EditText editCity;
    private EditText editBrgy;
    private EditText editWeight;
    private EditText editHeight;
    private EditText editPhone;
    private EditText editMothersName;
    private EditText editFathersName;
    private ArrayList<Validation> fieldsToValidate;
    private Context context;
    private ProgressDialog progressDialog;
    private ArrayList<BirthDayValidation> vaccineFieldsToValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        if(isFinishing()){
            return;
        }

        context = getApplicationContext();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            selectedVaccine = (Vaccine)bundle.getSerializable(Generic.SELECTED_VACCINE_TAG);
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);

        addValidations();
        getViews();
        autoFillUserInfo();
        addVaccineRequiredValidations();

        dateValidationSetup();

        setFormTitle();

        backButton = (ImageButton) findViewById(R.id.imgBtnBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity(EditProfileActivity.this, HomeActivity.class);
            }
        });

        confirmButton = findViewById(R.id.btnConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFormValid()) {
                    if (selectedVaccine == null) {

                    } else {

                    }
                }
            }
        });
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
            String url = Urls.GET_SERVER_TIME;

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
                new BirthDayValidation(EditProfileActivity.this, editBirthday)
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
                new NameValidation(context, editTextFirstName),
                new NameValidation(context, editTextLastName),
                new CityValidation(context, editCity),
                new BrgyValidation(context, editBrgy),
                new PhoneNumberValidation(context, editPhone)));
    }

    private boolean isFormValid(){
        for(Validation validation : fieldsToValidate){
            if(!validation.isValid()){
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
        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        editPhone = findViewById(R.id.editPhone);
        editMothersName = findViewById(R.id.editMothersName);
        editFathersName = findViewById(R.id.editFathersName);
        txtEditProfileTitle = findViewById(R.id.txtEditProfileTitle);
        changePasswordButton = findViewById(R.id.changePassButton);

    }

    private void autoFillUserInfo() {
        editTextFirstName.setText(currentUser.getFirstname());
        editTextLastName.setText(currentUser.getLastname());
        editBirthday.setText(currentUser.getDateOfBirthString());
        editBirthPlace.setText(currentUser.getPlaceofbirth());
        editCity.setText(currentUser.getCity());
        editBrgy.setText(currentUser.getBaranggay());
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