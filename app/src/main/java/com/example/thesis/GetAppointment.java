package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class GetAppointment extends AppCompatActivity {
    CardView cardAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_appointment);

        cardAppointment=(CardView)findViewById(R.id.cardAppointment);
        cardAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetAppointment.this, RegistrationForAppointment.class);
                startActivity(intent);
            }
        });
    }
}