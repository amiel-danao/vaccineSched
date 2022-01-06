package com.example.thesis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VaccinesAdapter extends RecyclerView.Adapter<VaccinesAdapter.VaccinesHolder>{
    Context context;
    List<Vaccine> vaccineList;

    public VaccinesAdapter(Context context, List<Vaccine> vaccineList) {
        this.context = context;
        this.vaccineList = vaccineList;
    }

    @NonNull
    @Override
    public VaccinesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vaccineLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccines_list,parent, false);
        return new VaccinesHolder(vaccineLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull VaccinesHolder holder, int position) {
        Vaccine vaccine = vaccineList.get(position);
        holder.Name.setText(vaccine.getName());
        holder.Description.setText(vaccine.getDescription());
    }

    @Override
    public int getItemCount() {
        return vaccineList.size();
    }

    public class VaccinesHolder extends RecyclerView.ViewHolder {
        TextView Name, Description, Dose;
        public VaccinesHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.rcy_name);
            Description = itemView.findViewById(R.id.rcy_description);
        }
    }

}

