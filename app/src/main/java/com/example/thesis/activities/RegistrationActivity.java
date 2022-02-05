package com.example.thesis.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.thesis.utilities.Generic;
import com.example.thesis.R;
import com.example.thesis.utilities.Urls;
import com.example.thesis.models.User;
import com.example.thesis.validations.BrgyValidation;
import com.example.thesis.validations.CityValidation;
import com.example.thesis.validations.EmailValidation;
import com.example.thesis.validations.LastNameValidation;
import com.example.thesis.validations.NameValidation;
import com.example.thesis.validations.PasswordValidation;
import com.example.thesis.validations.PhoneNumberValidation;
import com.example.thesis.validations.Validation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


public class RegistrationActivity extends AppCompatActivity {

    private Button registerbtn;
    private TextView txtViewAlready;
    private ProgressDialog progressDialog;
    private Validation[] fieldsToValidate;
    private Context context;
    private EditText Lastname;
    private EditText Email;
    private EditText Password;
    private EditText ConfirmPassword;
    private EditText Phone;
    private EditText edt_City;
    private EditText edt_Baranggay;
    private EditText Firstname;
    private EditText BrgyId;
    private EditText Suffix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtViewAlready = findViewById(R.id.txtViewAlready);
        registerbtn = findViewById(R.id.btnSubmit);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        Lastname = findViewById(R.id.lastname);
        Email = findViewById(R.id.email);
        ConfirmPassword = findViewById(R.id.conpassword);
        Password = findViewById(R.id.password);
        Phone = findViewById(R.id.phone);
        edt_City = findViewById(R.id.city);
        edt_Baranggay = findViewById(R.id.editBrgy);
        Firstname = findViewById(R.id.firstname);
        BrgyId = findViewById(R.id.editCardId);
        Suffix = findViewById(R.id.editSuffix);

        context = getApplicationContext();

        fieldsToValidate = new Validation[]{
                new NameValidation(context, Firstname),
                new LastNameValidation(context, Lastname),
                new CityValidation(context, edt_City),
                new BrgyValidation(context, edt_Baranggay),
                new EmailValidation(context, Email),
                new NameValidation(context, BrgyId),
                new PhoneNumberValidation(context, Phone),
                new PasswordValidation(context, Password)
        };

        /* FOR DEBUGGING ONLY */
        TextView txtAutoFill = findViewById(R.id.textView2);
        txtAutoFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firstname.setText("testfirstname");
                Lastname.setText("testlastname");
                Email.setText("test@email.com");
                Password.setText("Pass123@");
                ConfirmPassword.setText("Pass123@");
                Phone.setText("09912345678");
                edt_City.setText("Dasmariñas");
                edt_Baranggay.setText("Salawag");
                BrgyId.setText("SALAWAG-12345");
            }
        });
        /* FOR DEBUGGING ONLY */

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();


                if(!isFormValid()){
                    progressDialog.dismiss();
                }else{
                    residentExists();
                }
            }
        });


        txtViewAlready=(TextView) findViewById(R.id.txtViewAlready);
        txtViewAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isFormValid(){
        for(Validation validation : fieldsToValidate){
            if(!validation.isValid()){
                message(validation.getErrorMessage());
                validation.showError();
                return false;
            }if(!Password.getText().toString().equals(ConfirmPassword.getText().toString())){
                message("Password doesn't Match");
                return false;
            }
        }

        return true;
    }

    private void residentExists(){
        String url = Urls.GET_RESIDENT_URL;

        final String firstName = Firstname.getText().toString().trim();
        final String lastName = Lastname.getText().toString().trim();
        final String email = Email.getText().toString().trim();
        final String password = Password.getText().toString().trim();
        final String city = edt_City.getText().toString().trim();
        final String brgy = edt_Baranggay.getText().toString().trim();
        final String phone = Phone.getText().toString().trim();
        final String brgyId = BrgyId.getText().toString().trim();
        final String suffix = Suffix.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            Log.d(Generic.TAG, "Response is : " + response);
            if(response.equals("OK"))
            {
                Log.d(Generic.TAG, "OK to register");
                userExists(email, brgyId,
                new Callable<Void>() {
                    public Void call() {
                        message("user already exist!");
                        progressDialog.dismiss();
                        return null;
                    }
                },
                new Callable<Void>() {
                    public Void call() {
                        registerUser(firstName, lastName, email, city, brgy, phone, password, suffix, brgyId);
                        return null;
                    }
                });
            }
            else {
                Log.d(Generic.TAG, "Resident not allowed to register!");
                message("Resident not allowed to register!");
                progressDialog.dismiss();
            }

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
                params.put("firstname", firstName);
                params.put("lastname", lastName);
                params.put("suffix", suffix);
                params.put("card_id", brgyId);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
        requestQueue.add(request);
    }

    private void userExists(String email, String brgId, Callable<Void> callbackExist, Callable<Void> callbackNotExist){
        String url = Urls.GET_USER_URL;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            if(response.equals("User doesn't exist"))
            {
                try {
                    callbackNotExist.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    User user = new Gson().fromJson(response, User.class);

                    if (user != null) {
                        try {
                            callbackExist.call();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JsonSyntaxException exception) {
                    //Toast.makeText(REGISTER_FORM.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                    message(response);
                    progressDialog.hide();
                }
            }

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
                params.put("email", email);
                params.put("brg_id", brgId);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
        requestQueue.add(request);
    }

    private void registerUser(String firstname, String lastname, String email, String city,
                              String brgy, String phone, String password, String suffix, String brgy_id) {

        progressDialog.setMessage("Creating Your Account");
        progressDialog.show();

        String url = Urls.REGISTER_URL;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            try {
                User user = new Gson().fromJson(response, User.class);

                if (user != null) {
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    message("Account Created Successfully");
                    finish();
                }
            }
            catch (JsonSyntaxException exception){
                Toast.makeText(RegistrationActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
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
                params.put("firstname", firstname);
                params.put("lastname", lastname);
                params.put("email", email);
                params.put("city", city);
                params.put("brgy", brgy);
                params.put("phone" ,phone);
                params.put("password", password);
                params.put("suffix", suffix);
                params.put("brg_id", brgy_id);
                return params;
            }
        };

        //AppController.getInstance().addToQueue(request, "edit_data");

        RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
        requestQueue.add(request);
    }

    public void message(String message){
        Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_LONG).show();
    }
}










