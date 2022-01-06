package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationForAppointment extends AppCompatActivity {

    private Button btnConfirmV;
    ImageButton imgBtnBack;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_for_appointment);

        btnConfirmV = (Button) findViewById(R.id. btnConfirmV);
        btnConfirmV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationForAppointment.this, ConfirmationAppointment.class);
                startActivity(intent);
            }
        });
        imgBtnBack = (ImageButton) findViewById(R.id.imgBtnBack);
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationForAppointment.this, GetAppointment.class);
                startActivity(intent);
            }
        });



    }
}