package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thesis.activities.HomeActivity;

public class ConfirmationAppointment extends AppCompatActivity {
    private Button btnConfirmVac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_appointment);

        btnConfirmVac= (Button) findViewById(R.id.btnConfirmVac);
        btnConfirmVac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmationAppointment.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}