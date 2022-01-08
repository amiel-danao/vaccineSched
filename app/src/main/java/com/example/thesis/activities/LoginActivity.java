package com.example.thesis.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
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
import com.example.thesis.validations.EmailValidation;
import com.example.thesis.validations.PasswordValidation;
import com.example.thesis.validations.Validation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText Email, Password;
    private Button LoginButton;
    private ProgressDialog progressDialog;
    private TextView tvcreate;
    private Validation[] fieldsToValidate;
    private Context context;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        LoginButton = (Button) findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        context = getApplicationContext();

        fieldsToValidate = new Validation[]{
                new EmailValidation(context, Email),
                new PasswordValidation(context, Password)
        };
        
        /* FOR DEBUGGING PURPOSE ONLY */
        TextView textAutoFill = findViewById(R.id.textView);
        textAutoFill.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Email.setText("test@email.com");
                Password.setText("Password123$");
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {                
                if (isFormValid()) {
                    UserLogin(Email.getText().toString(), Password.getText().toString());
                } else {
                    message("Wrong email or password!");
                }
            }
        });

        tvcreate = findViewById(R.id.textviewcreate);
        tvcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void UserLogin(String EmailHolder, String PasswordHolder) {
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Urls.LOGIN_URL, response -> {
            try {
                User user = new Gson().fromJson(response, User.class);
                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();
                    finish();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra(Generic.USER_LOGGED_IN_TAG, user);
                    startActivity(intent);
                    message("User Login Successfully");
                }
                else{
                    //message(response);
                    message("Wrong email or password!");
                }
            }
            catch (JsonSyntaxException exception){
                //message(exception.getMessage());
                message("Wrong email or password!");
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
            @Override 
            protected Map < String, String > getParams() {
                Map < String, String > params = new HashMap < String, String > ();
                params.put("email", EmailHolder);
                params.put("password", PasswordHolder);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
    }

    private boolean isFormValid(){
        for(Validation validation : fieldsToValidate){
            if(!validation.isValid()){
                return false;
            }
        }

        return true;
    }

    private void message(String message){
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
