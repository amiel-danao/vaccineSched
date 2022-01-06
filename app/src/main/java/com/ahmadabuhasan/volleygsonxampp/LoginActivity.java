package com.android_examples.volleyuserlogin_android_examplescom;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
public class LoginActivity extends AppCompatActivity {
    EditText Email, Password;
    Button LoginButton;
    RequestQueue requestQueue;
    String EmailHolder, PasswordHolder;
    ProgressDialog progressDialog;
    Boolean CheckEditText;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = (EditText) findViewById(R.id.editText_Email);
        Password = (EditText) findViewById(R.id.editText_Password);
        LoginButton = (Button) findViewById(R.id.button_login);
        requestQueue = Volley.newRequestQueue(LoginActivity.this);
        progressDialog = new ProgressDialog(LoginActivity.this);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    UserLogin();
                } else {
                    Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void UserLogin() {
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

	StringRequest request = new StringRequest(Request.Method.POST, ApiClient.URL_LOGIN, response -> {
            User user = new Gson().fromJson(response, User.class);
	    progressDialog.dismiss();
            if (user != null) {
                Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();
                finish();
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                intent.putExtra("userLoggedIn", user);
                startActivity(intent);
            }
            else{
                Toast.makeText(LoginActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            
            if (error instanceof TimeoutError) {
                Toast.makeText(LoginActivity.this, "Network TimeoutError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NoConnectionError) {
                Toast.makeText(LoginActivity.this, "Nerwork NoConnectionError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof AuthFailureError) {
                Toast.makeText(LoginActivity.this, "Network AuthFailureError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ServerError) {
                Toast.makeText(LoginActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NetworkError) {
                Toast.makeText(LoginActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ParseError) {
                Toast.makeText(LoginActivity.this, "Parse Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Status Error!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override protected Map < String, String > getParams() {
                Map < String, String > params = new HashMap < String, String > ();
                params.put("email", EmailHolder);
                params.put("password", PasswordHolder);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }

    public void CheckEditTextIsEmptyOrNot() {
        EmailHolder = Email.getText().toString().trim();
        PasswordHolder = Password.getText().toString().trim();
        if (TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)) {
            CheckEditText = false;
        } else {
            CheckEditText = true;
        }
    }
}