package com.example.thesis;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.thesis.validations.BrgyValidation;
import com.example.thesis.validations.CityValidation;
import com.example.thesis.validations.EmailValidation;
import com.example.thesis.validations.NameValidation;
import com.example.thesis.validations.PasswordValidation;
import com.example.thesis.validations.PhoneNumberValidation;
import com.example.thesis.validations.Validation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


public class REGISTER_FORM extends AppCompatActivity {

    private Button registerbtn;
    private TextView txtViewAlready;
    private ProgressDialog progressDialog;
    private Validation[] fieldsToValidate;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_e_g_i_s_t_e_r__f_o_r_m);
        txtViewAlready = findViewById(R.id.txtViewAlready);
        registerbtn = findViewById(R.id.btnSubmit);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        final EditText Lastname = findViewById(R.id.lastname);
        final EditText Email = findViewById(R.id.email);
        final EditText Password = findViewById(R.id.password);
        final EditText Phone = findViewById(R.id.phone);
        final EditText edt_City = findViewById(R.id.city);
        final EditText edt_Baranggay = findViewById(R.id.editBrgy);
        final EditText Firstname = findViewById(R.id.firstname);
        context = getApplicationContext();

        fieldsToValidate = new Validation[]{
                new NameValidation(context, Firstname),
                new NameValidation(context, Lastname),
                new CityValidation(context, edt_City),
                new BrgyValidation(context, edt_Baranggay),
                new EmailValidation(context, Email),
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
                Password.setText("Password123$");
                Phone.setText("09912345678");
                edt_City.setText("Dasmariñas");
                edt_Baranggay.setText("Salawag");
            }
        });
        /* FOR DEBUGGING ONLY */

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                final String firstname = Firstname.getText().toString().trim();
                final String lastname = Lastname.getText().toString().trim();
                final String email = Email.getText().toString().trim();
                final String password = Password.getText().toString().trim();
                final String city = edt_City.getText().toString().trim();
                final String brgy = edt_Baranggay.getText().toString().trim();
                final String phone = Phone.getText().toString().trim();

                if(!isFormValid()){
                    progressDialog.dismiss();
                }else{

                    userExists(email,
                         new Callable<Void>() {
                        public Void call() {
                            message("email already in use!");
                            progressDialog.dismiss();
                            return null;
                        }
                    },
                            new Callable<Void>() {
                                public Void call() {
                                        registerUser(firstname, lastname, email, city, brgy, phone, password);
                                    return null;
                                }
                            });
                }
            }
        });


        txtViewAlready=(TextView) findViewById(R.id.txtViewAlready);
        txtViewAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(REGISTER_FORM.this, LoginActivity.class);
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
            }
        }

        return true;
    }

    private void userExists(String email, Callable<Void> callbackExist, Callable<Void> callbackNotExist){
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
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(REGISTER_FORM.this);
        requestQueue.add(request);
    }

    private void registerUser(String firstname, String lastname, String email, String city, String brgy, String phone, String password) {
        progressDialog.show();

        String url = Urls.REGISTER_URL;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            try {
                User user = new Gson().fromJson(response, User.class);

                if (user != null) {

                    Intent intent = new Intent(REGISTER_FORM.this, MainActivity3.class);
                    intent.putExtra(Generic.USER_LOGGED_IN_TAG, user);
                    startActivity(intent);
                    finish();
                }
            }
            catch (JsonSyntaxException exception){
                Toast.makeText(REGISTER_FORM.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        }, error -> {

            if (error instanceof TimeoutError) {
                Toast.makeText(REGISTER_FORM.this, "Network TimeoutError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NoConnectionError) {
                Toast.makeText(REGISTER_FORM.this, "Nerwork NoConnectionError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof AuthFailureError) {
                Toast.makeText(REGISTER_FORM.this, "Network AuthFailureError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ServerError) {
                Toast.makeText(REGISTER_FORM.this, "Server Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NetworkError) {
                Toast.makeText(REGISTER_FORM.this, "Network Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ParseError) {
                Toast.makeText(REGISTER_FORM.this, "Parse Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(REGISTER_FORM.this, "Status Error!", Toast.LENGTH_SHORT).show();
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
                return params;
            }
        };

        //AppController.getInstance().addToQueue(request, "edit_data");

        RequestQueue requestQueue = Volley.newRequestQueue(REGISTER_FORM.this);
        requestQueue.add(request);
    }

public void message(String message){
    Toast.makeText(REGISTER_FORM.this, message, Toast.LENGTH_LONG).show();
}





}










