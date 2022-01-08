package com.example.thesis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class VaccinesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Vaccine> vaccineList;
    private RecyclerViewAdapter vaccinesAdapter;
    private User currentUser;
    private ProgressDialog progressDialog;

    //vaccine information
     @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_vaccine);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.vaccines_loading_message));
        progressDialog.setCancelable(false);

        checkLoggedInUser();

        recyclerView = findViewById(R.id.vaccinesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LoadAllVaccines();
    }

    private void checkLoggedInUser() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            currentUser = (User)bundle.getSerializable(Generic.USER_LOGGED_IN_TAG);
        }

        if(currentUser == null){
            finish();
            intent = new Intent(VaccinesActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void LoadAllVaccines() {
        progressDialog.show();
        String url = Urls.GET_AVAILABLE_VACCINES;

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {

                Type typeModelVaccines = new TypeToken<ArrayList<Vaccine>>() {
                }.getType();

                vaccineList = new Gson().fromJson(response, typeModelVaccines);
                vaccinesAdapter = new RecyclerViewAdapter(VaccinesActivity.this, vaccineList, currentUser);
                recyclerView.setAdapter(vaccinesAdapter);

            } catch (Exception e) {
                message(e.getMessage());
                e.printStackTrace();
            }

            progressDialog.dismiss();
        }, error -> {
            if (error instanceof TimeoutError) {
                Toast.makeText(VaccinesActivity.this, "Network TimeoutError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NoConnectionError) {
                Toast.makeText(VaccinesActivity.this, "Nerwork NoConnectionError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof AuthFailureError) {
                Toast.makeText(VaccinesActivity.this, "Network AuthFailureError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ServerError) {
                Toast.makeText(VaccinesActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NetworkError) {
                Toast.makeText(VaccinesActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ParseError) {
                Toast.makeText(VaccinesActivity.this, "Parse Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(VaccinesActivity.this, "Status Error!", Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();
        });

        RequestQueue requestQueue = Volley.newRequestQueue(VaccinesActivity.this);
        requestQueue.add(request);
    }

    private void message(String message){
        Toast.makeText(VaccinesActivity.this, message, Toast.LENGTH_LONG).show();
    }
}