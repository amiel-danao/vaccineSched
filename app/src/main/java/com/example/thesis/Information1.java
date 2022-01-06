package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Information1 extends AppCompatActivity {
    private Button btnVacnSelect;
    ImageView mainImageView;
    TextView title,description,dose;

    String data1,data2,data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information1);


        btnVacnSelect= (Button) findViewById(R.id.btnVacnSelect);
        btnVacnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information1.this, GetAppointment.class);
                startActivity(intent);
            }
        });

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title1);
        description = findViewById(R.id.description1);
        dose = findViewById(R.id.dose);
        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")&&getIntent().hasExtra("data3")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");


        }else{
            Toast.makeText(this,"No data.",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        dose.setText(data3);

    }




}
