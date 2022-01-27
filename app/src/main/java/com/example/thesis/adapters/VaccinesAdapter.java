package com.example.thesis.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.R;
import com.example.thesis.activities.VaccinePreviewActivity;
import com.example.thesis.models.User;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.Generic;

import java.util.ArrayList;


public class VaccinesAdapter extends RecyclerView.Adapter<VaccinesAdapter.ViewHolder> implements Filterable {

    private final Context context;
    public ArrayList<Vaccine> arrayVaccines, dataFilter;
    CustomFilter filter;
    private User currentUser;

    public VaccinesAdapter(Context context, ArrayList<Vaccine> arrayVaccines, User currentUser) {
        this.context = context;
        this.arrayVaccines = arrayVaccines;
        this.dataFilter = arrayVaccines;
        this.currentUser = currentUser;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_vaccine, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vaccine vaccine = arrayVaccines.get(position);
        
        holder.txt_vaccine_name.setText(vaccine.getName());
        holder.txt_dose.setText(String.valueOf(vaccine.getDose()));
    }

    @Override
    public int getItemCount() {
		if(arrayVaccines == null){
			return 0;
		}
        return arrayVaccines.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter(dataFilter, this);
        }
        return filter;
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        
        private final TextView txt_vaccine_name;
        private final TextView txt_dose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_vaccine_name = itemView.findViewById(R.id.rcy_name);
            txt_dose = itemView.findViewById(R.id.rcy_dose);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Vaccine vaccine = arrayVaccines.get(position);

                Intent intent1 = new Intent(context, VaccinePreviewActivity.class);
                intent1.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
                intent1.putExtra(Generic.SELECTED_VACCINE_TAG, vaccine);
                context.startActivity(intent1);
            });
        }
    }
}
