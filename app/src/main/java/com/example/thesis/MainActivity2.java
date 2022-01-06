package com.example.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.view.View;

public class MainActivity2 extends AppCompatActivity{
    //vaccine information
    RecyclerView recyclerView;
    String s1[],s2[];
    int images[] ={R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);


        s1=getResources().getStringArray(R.array.vaccine);
        s2=getResources().getStringArray(R.array.description);


        MyAdapter myAdapter =new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}