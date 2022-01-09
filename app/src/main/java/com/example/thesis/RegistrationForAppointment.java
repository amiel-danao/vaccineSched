package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thesis.activities.AppointmentConfirmationActivity;
import com.example.thesis.activities.SchedulesActivity;

public class RegistrationForAppointment extends AppCompatActivity {

    private Button btnConfirmV;
    ImageButton imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnConfirmV = (Button) findViewById(R.id.btnConfirm);
        btnConfirmV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationForAppointment.this, AppointmentConfirmationActivity.class);
                startActivity(intent);
            }
        });
        imgBtnBack = (ImageButton) findViewById(R.id.imgBtnBack);
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationForAppointment.this, SchedulesActivity.class);
                startActivity(intent);
            }
        });
    }
}