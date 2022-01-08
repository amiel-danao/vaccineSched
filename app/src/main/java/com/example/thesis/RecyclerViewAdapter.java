package com.example.thesis;

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

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private final Context context;
    ArrayList<Vaccine> arrayVaccines, dataFilter;
    CustomFilter filter;
    private User currentUser;

    public RecyclerViewAdapter(Context context, ArrayList<Vaccine> arrayVaccines, User currentUser) {
        this.context = context;
        this.arrayVaccines = arrayVaccines;
        this.dataFilter = arrayVaccines;
        this.currentUser = currentUser;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vaccines_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vaccine Vaccine = arrayVaccines.get(position);
        
        holder.txt_vaccine_name.setText(Vaccine.getName());
        holder.txt_dose.setText(String.valueOf(Vaccine.getDose()));
    }

    @Override
    public int getItemCount() {
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
