package com.example.thesis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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
import com.example.thesis.activities.AuthenticatedActivity;
import com.example.thesis.activities.LoginActivity;
import com.example.thesis.activities.VaccinePreviewActivity;
import com.example.thesis.activities.VaccinesActivity;
import com.example.thesis.adapters.SchedulesAdapter;
import com.example.thesis.models.Schedule;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.Generic;
import com.example.thesis.utilities.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SchedulesActivity extends AuthenticatedActivity {
    private RecyclerView recyclerView;
    private ArrayList<Schedule> schedulesList;
    private SchedulesAdapter schedulesAdapter;
    private Vaccine selectedVaccine;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);

        if(isFinishing()){
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.schedules_loading));
        progressDialog.setCancelable(false);

        checkSelectedVaccine();

        recyclerView = findViewById(R.id.schedulesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LoadAllSchedules();
    }

    private void checkSelectedVaccine() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            selectedVaccine = (Vaccine)bundle.getSerializable(Generic.SELECTED_VACCINE_TAG);
        }

        if(selectedVaccine == null){
            finish();
            intent = new Intent(SchedulesActivity.this, VaccinesActivity.class);
            startActivity(intent);
        }
    }

    private void LoadAllSchedules() {
        progressDialog.show();
        String url = Urls.GET_AVAILABLE_SCHEDULES;

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {

                Type typeModelSchedules = new TypeToken<ArrayList<Schedule>>() {
                }.getType();

                schedulesList = new Gson().fromJson(response, typeModelSchedules);
                schedulesAdapter = new SchedulesAdapter(SchedulesActivity.this, schedulesList, currentUser);
                recyclerView.setAdapter(schedulesAdapter);

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

        RequestQueue requestQueue = Volley.newRequestQueue(SchedulesActivity.this);
        requestQueue.add(request);
    }

    private void message(String message){
        Toast.makeText(SchedulesActivity.this, message, Toast.LENGTH_LONG).show();
    }
}