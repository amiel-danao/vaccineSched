package com.example.thesis.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

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
import com.example.thesis.R;
import com.example.thesis.adapters.AppointmentAdapter;
import com.example.thesis.models.Appointment;
import com.example.thesis.utilities.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistoryActivity extends AuthenticatedActivity {

    private RecyclerView recyclerView;
    private ArrayList<Appointment> appointments;
    private AppointmentAdapter appointmentAdapter;
    private ProgressDialog progressDialog;
    private Context context;
    private String serverDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        if(isFinishing()){
            return;
        }

        context = getApplicationContext();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading_your_appointments));
        progressDialog.setCancelable(false);

        recyclerView = findViewById(R.id.appointmentsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getServerDate();
    }

    private void getServerDate() {

        progressDialog.show();
        String url = Urls.GET_SERVER_DATE;

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            serverDate = response;
            LoadAllOngoingAppointments();

            progressDialog.dismiss();
        }, error -> {
            progressDialog.dismiss();
        });

        RequestQueue requestQueue = Volley.newRequestQueue(HistoryActivity.this);
        requestQueue.add(request);
    }

    private void LoadAllOngoingAppointments() {
        progressDialog.show();
        String url = Urls.GET_HISTORY_APPOINTMENTS;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            try {

                Type typeModelAppointments = new TypeToken<ArrayList<Appointment>>() {
                }.getType();

                appointments = new Gson().fromJson(response, typeModelAppointments);
                appointmentAdapter = new AppointmentAdapter(HistoryActivity.this, appointments,
                        currentUser,  serverDate);
                recyclerView.setAdapter(appointmentAdapter);

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
        }){
            @Override
            protected Map< String, String > getParams() {
                Map < String, String > params = new HashMap< String, String >();
                params.put("user_id", String.valueOf(currentUser.getUser_id()));
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(HistoryActivity.this);
        requestQueue.add(request);
    }

    private void message(String message){
        Toast.makeText(HistoryActivity.this, message, Toast.LENGTH_LONG).show();
    }
}