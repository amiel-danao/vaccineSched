package com.example.thesis.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.activities.AppointmentConfirmationActivity;
import com.example.thesis.R;
import com.example.thesis.activities.EditProfileActivity;
import com.example.thesis.activities.SchedulesActivity;
import com.example.thesis.models.Schedule;
import com.example.thesis.models.User;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.Generic;
import com.example.thesis.validations.UserValidator;

import java.util.ArrayList;

public class SchedulesAdapter extends RecyclerView.Adapter<SchedulesAdapter.ViewHolder>{
    private final Context context;
    private final Vaccine selectedVaccine;
    ArrayList<Schedule> scheduleList;
    private final User currentUser;
    private UserValidator userValidator;

    public SchedulesAdapter(Context context, ArrayList<Schedule> scheduleList, User currentUser, Vaccine selectedVaccine, String serverDate) {
        this.context = context;
        this.scheduleList = scheduleList;
        this.currentUser = currentUser;
        this.selectedVaccine = selectedVaccine;
        userValidator = new UserValidator(this.context, currentUser, serverDate);
    }

    @NonNull
    @Override
    public SchedulesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_schedule, parent, false);
        return new SchedulesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Schedule schedule = scheduleList.get(position);

        holder.txt_schedule_date.setText(schedule.getWordDateString(context));
        holder.txt_schedule_time.setText(schedule.getTime());
        holder.txt_schedule_place.setText(schedule.getPlace());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt_schedule_date;
        private final TextView txt_schedule_time;
        private final TextView txt_schedule_place;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_schedule_date = itemView.findViewById(R.id.dateAvai);
            txt_schedule_time = itemView.findViewById(R.id.timeAvai);
            txt_schedule_place = itemView.findViewById(R.id.placeAvai);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Schedule schedule = scheduleList.get(position);

                if(userValidator.isUserValid()){
                    gotoNextActivity(schedule, AppointmentConfirmationActivity.class);
                }
                else{
                    gotoNextActivity(schedule, EditProfileActivity.class);
                    message(userValidator.getInvalidMessage());
                }
            });
        }
    }

    private void message(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    private void gotoNextActivity(Schedule schedule, Class<?> cls){
        Intent intent = new Intent(context, cls);
        intent.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
        intent.putExtra(Generic.SELECTED_VACCINE_TAG, selectedVaccine);
        intent.putExtra(Generic.SELECTED_SCHEDULE, schedule);
        context.startActivity(intent);
    }
}
