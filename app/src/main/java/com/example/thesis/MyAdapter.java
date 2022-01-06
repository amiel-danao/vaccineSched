package com.example.thesis;
 import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

     String data1[],data2[];
     int images[];
     Context context;
     public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context= ct;
        data1=s1;
        data2=s2;
        images=img;
     }
     @NonNull
     @Override
     public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         LayoutInflater inflater = LayoutInflater.from(context);
         View view =inflater.inflate(R.layout.my_row,parent, false);
         return new MyViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtTitleV.setText(data1[position]);
        holder.txtDescrip.setText(data2[position]);
        holder.myimgView.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Infomation.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("myimgView",images[position]);
                context.startActivity(intent);
            }
        });
     }

     @Override
     public int getItemCount() {

         return images.length;
     }

     public class MyViewHolder extends RecyclerView.ViewHolder{

         TextView txtTitleV,txtDescrip;
         ImageView myimgView;
         ConstraintLayout mainLayout;

         public MyViewHolder(@NonNull View itemView) {
             super(itemView);
                txtTitleV = itemView.findViewById(R.id.rcy_name);
                txtDescrip = itemView.findViewById(R.id.txtDescrip);
                myimgView=itemView.findViewById(R.id.myimgView);
                mainLayout=itemView.findViewById(R.id.mainLayout);
         }
     }
 }
