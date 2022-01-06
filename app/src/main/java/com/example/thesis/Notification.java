package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {
    private Button btnViewNotif;
    ImageButton imgbtnBack2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);



        btnViewNotif = (Button) findViewById(R.id.btnViewNotif);
        btnViewNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notification.this, NotificationView.class);
                startActivity(intent);
            }
        });






    }
}