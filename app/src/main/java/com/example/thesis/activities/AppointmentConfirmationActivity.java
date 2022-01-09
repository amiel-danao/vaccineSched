package com.example.thesis.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thesis.R;
import com.example.thesis.models.Schedule;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.Generic;

public class AppointmentConfirmationActivity extends AuthenticatedActivity {
    private Vaccine selectedVaccine;
    private Schedule selectedSchedule;
    private TextView txt_scheduleDate;
    private TextView txt_scheduleTime;
    private TextView txt_vaccineName;
    private TextView txt_vaccineDose;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_confirmation);

        if(isFinishing()){
            return;
        }

        context = getApplicationContext();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            selectedVaccine = (Vaccine)bundle.getSerializable(Generic.SELECTED_VACCINE_TAG);
            selectedSchedule = (Schedule) bundle.getSerializable(Generic.SELECTED_SCHEDULE);
        }

        getViews();
        fillScheduleInfo();

        Button btnConfirmVac = (Button) findViewById(R.id.btnConfirmVac);
        btnConfirmVac.setOnClickListener(v -> {
            checkIfAlreadyAppointed();
        });
    }

    private void checkIfAlreadyAppointed() {

    }

    private void addAppointment(){
        Intent intent1 = new Intent(AppointmentConfirmationActivity.this, HomeActivity.class);
        startActivity(intent1);
    }

    private void fillScheduleInfo() {
        txt_scheduleDate.setText(selectedSchedule.getWordDateString(context));
        txt_scheduleTime.setText(selectedSchedule.getTime());
        txt_vaccineName.setText(selectedVaccine.getName());
        txt_vaccineDose.setText(String.valueOf(selectedVaccine.getDose()));
    }

    private void getViews() {
        txt_scheduleDate = findViewById(R.id.dateAppointment);
        txt_scheduleTime = findViewById(R.id.timeAppointment);
        txt_vaccineName = findViewById(R.id.vaccineAppointment);
        txt_vaccineDose = findViewById(R.id.doseAppointment);
    }
}