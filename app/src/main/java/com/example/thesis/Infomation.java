package com.example.thesis;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Infomation extends AppCompatActivity {

    ImageView mainImageView;
    TextView title,description;

    String data1,data2;
    int myimgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title1);
        description = findViewById(R.id.description1);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myimgView") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") ){

                data1 = getIntent().getStringExtra("data1");
                data2 = getIntent().getStringExtra("data2");
                myimgView = getIntent().getIntExtra("myimgView",1);

        }else{
            Toast.makeText(this,"No data.",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myimgView);
    }
}