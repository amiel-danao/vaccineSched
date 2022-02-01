package com.example.thesis.activities;

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
import com.example.thesis.utilities.Generic;
import com.example.thesis.R;
import com.example.thesis.utilities.Urls;
import com.example.thesis.adapters.VaccinesAdapter;
import com.example.thesis.models.User;
import com.example.thesis.models.Vaccine;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class VaccinesActivity extends AuthenticatedActivity {
    private RecyclerView recyclerView;
    private ArrayList<Vaccine> vaccineList;
    private VaccinesAdapter vaccinesAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines);

        if(isFinishing()){
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.vaccines_loading_message));
        progressDialog.setCancelable(false);

        recyclerView = findViewById(R.id.vaccinesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LoadAllVaccines();
    }

    private void LoadAllVaccines() {
        progressDialog.show();
        String url = Urls.GET_AVAILABLE_VACCINES;

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {

                Type typeModelVaccines = new TypeToken<ArrayList<Vaccine>>() {
                }.getType();

                vaccineList = new Gson().fromJson(response, typeModelVaccines);
                vaccinesAdapter = new VaccinesAdapter(VaccinesActivity.this, vaccineList, currentUser);
                recyclerView.setAdapter(vaccinesAdapter);

            } catch (Exception e) {
                message(e.getMessage());
                e.printStackTrace();
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
        });

        RequestQueue requestQueue = Volley.newRequestQueue(VaccinesActivity.this);
        requestQueue.add(request);
    }

    private void message(String message){
        Toast.makeText(VaccinesActivity.this, message, Toast.LENGTH_LONG).show();
    }
}