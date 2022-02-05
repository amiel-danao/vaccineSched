package com.example.thesis.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

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
import com.example.thesis.models.Schedule;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.DateUtil;
import com.example.thesis.utilities.Generic;
import com.example.thesis.utilities.Urls;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class AppointmentConfirmationActivity extends AuthenticatedActivity {
    private Vaccine selectedVaccine;
    private Schedule selectedSchedule;
    private TextView txt_scheduleDate;
    private TextView txt_scheduleTime;
    private TextView txt_vaccineName;
    private TextView txt_vaccineDose;
    private TextView txt_schedulePlace;
    private Context context;
    private ProgressDialog progressDialog;
    private String answersCheckList;
    private String answersScreening;
    private String appoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_confirmation);

        if(isFinishing()){
            return;
        }
 
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        
        if (intent.hasExtra("answersCheckList")) {
             answersCheckList = bundle.getString("answersCheckList");
        }

        if (intent.hasExtra("answersScreening")) {
             answersScreening = bundle.getString("answersScreening");
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        context = getApplicationContext();
        
        if(bundle != null){
            selectedVaccine = (Vaccine)bundle.getSerializable(Generic.SELECTED_VACCINE_TAG);
            selectedSchedule = (Schedule) bundle.getSerializable(Generic.SELECTED_SCHEDULE);
        }

        getViews();
        fillScheduleInfo();

        Button btnConfirmVac = (Button) findViewById(R.id.btnConfirmVac);
        btnConfirmVac.setOnClickListener(v -> {
            checkIfAlreadyAppointed(
                    () -> {
                        message(getString(R.string.message_already_have_appointment));
                        return null;
                    },
                    () -> {
                        addAppointment();
                        return null;
                    }
            );
        });
    }

    private void checkIfAlreadyAppointed(Callable<Void> callbackExist, Callable<Void> callbackNotExist) {
        progressDialog.setMessage(getString(R.string.loading_checking_existing_appointments));
        progressDialog.show();
        String url = Urls.GET_APPOINTMENT;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            if(response.equals("Appointment doesn't exist"))
            {
                try {
                    callbackNotExist.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    callbackExist.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                params.put("user_id", String.valueOf(currentUser.getUser_id()));
                params.put("appo_date", DateUtil.dateToString(selectedSchedule.getDate(),
                        context.getResources().getString(R.string.simple_date_format)));
                params.put("appo_time", selectedSchedule.getTime());
                params.put("place", selectedSchedule.getPlace());
                params.put("vaccine" , selectedVaccine.getName());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(AppointmentConfirmationActivity.this);
        requestQueue.add(request);
    }

    private void saveAnswers() {
        progressDialog.setMessage(getString(R.string.loading_saving_answers));
        progressDialog.show();
        String url = Urls.UPDATE_ANSWERS_URL;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            Log.d(Generic.TAG, "Response is : " + response);
            if(response.equals("User updated Successfully"))
            {
                finish();
                gotoActivity(AppointmentConfirmationActivity.this, HomeActivity.class);
                message("Appointment was selected Successfully");
            }
            else {
                message("Saving failed!");
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
                params.put("user_id", String.valueOf(currentUser.getUser_id()));
                params.put("answers_checklist", answersCheckList);
                params.put("answers_screening", answersScreening);
                params.put("appo_id", appoId);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(AppointmentConfirmationActivity.this);
        requestQueue.add(request);
    }

    private void addAppointment(){
        progressDialog.setMessage(getString(R.string.loading_saving_appointment));
        progressDialog.show();

        String url = Urls.ADD_APPOINTMENT;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            appoId = response;
            if(!response.equals("-1")){
                saveAnswers();
            }
            else{
                message(response);
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
                params.put("firstname", currentUser.getFirstname());
                params.put("lastname", currentUser.getLastname());
                params.put("phonenumber", currentUser.getPhone());
                params.put("appo_date", DateUtil.dateToString(selectedSchedule.getDate(),
                        context.getResources().getString(R.string.simple_date_format)));
                params.put("appo_time", selectedSchedule.getTime());
                params.put("vaccine" , selectedVaccine.getName());
                params.put("user_id", String.valueOf(currentUser.getUser_id()));
                params.put("nurse", selectedSchedule.getNurse());
                params.put("place", selectedSchedule.getPlace());
                params.put("email", currentUser.getEmail());
                params.put("status", getString(R.string.default_appointment_status));
                params.put("scheduleId", String.valueOf(selectedSchedule.getId()));
                params.put("capacity", String.valueOf(Math.max(0, selectedSchedule.getCapacity() - 1)));

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(AppointmentConfirmationActivity.this);
        requestQueue.add(request);
    }

    private void fillScheduleInfo() {
        txt_scheduleDate.setText(selectedSchedule.getWordDateString(context));
        txt_scheduleTime.setText(selectedSchedule.getTime());
        txt_vaccineName.setText(selectedVaccine.getName());
        txt_vaccineDose.setText(String.valueOf(selectedVaccine.getDose()));
        txt_schedulePlace.setText(selectedSchedule.getPlace());
    }

    private void getViews() {
        txt_scheduleDate = findViewById(R.id.dateAppointment);
        txt_scheduleTime = findViewById(R.id.timeAppointment);
        txt_vaccineName = findViewById(R.id.vaccineAppointment);
        txt_vaccineDose = findViewById(R.id.statusAppointment);
        txt_schedulePlace = findViewById(R.id.placeAppointment);
    }

    public void message(String message){
        Toast.makeText(AppointmentConfirmationActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
