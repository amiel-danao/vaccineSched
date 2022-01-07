package com.example.thesis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText Email, Password;
    private Button LoginButton;
    private String EmailHolder, PasswordHolder;
    private ProgressDialog progressDialog;
    private TextView tvcreate;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n__f_o_r_m);

        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        LoginButton = (Button) findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        
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
                    UserLogin();
                } else {
                    message("Please fill all form fields.");
                }
            }
        });

        tvcreate = findViewById(R.id.textviewcreate);
        tvcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, REGISTER_FORM.class);
                startActivity(intent);
            }
        });
    }

    private void UserLogin() {
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Urls.LOGIN_URL, response -> {
            try {
                User user = new Gson().fromJson(response, User.class);
                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();
                    finish();
                    Intent intent = new Intent(LoginActivity.this, MainActivity3.class);
                    intent.putExtra(Generic.UserLoggedIn, user);
                    startActivity(intent);
                    message("User Login Successfully");
                }
                else{
                    message(response);
                }
            }
            catch (JsonSyntaxException exception){
                message(exception.getMessage());
            }
            
            progressDialog.dismiss();
        }, error -> {

            if (error instanceof TimeoutError) {
                message("Network TimeoutError");
            } else if (error instanceof NoConnectionError) {
                message("Nerwork NoConnectionError");
            } else if (error instanceof AuthFailureError) {
                message("Network AuthFailureError");
            } else if (error instanceof ServerError) {
                message("Server Error");
            } else if (error instanceof NetworkError) {
                message("Network Error");
            } else if (error instanceof ParseError) {
                message("Parse Error");
            } else {
                message("Status Error!");
            }
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

    private boolean isFormValid()() {
        EmailHolder = Email.getText().toString().trim();
        PasswordHolder = Password.getText().toString().trim();
        return !(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder));
    }

    private void message(String message){
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
