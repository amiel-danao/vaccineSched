package com.example.thesis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.R;
import com.example.thesis.models.Appointment;
import com.example.thesis.models.Schedule;
import com.example.thesis.models.User;
import com.example.thesis.utilities.DateUtil;

import java.util.ArrayList;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder>{
    private final Context context;
    private ArrayList<Appointment> appointmentsList;
    private final User currentUser;

    public AppointmentAdapter(Context context, ArrayList<Appointment> appointmentsList, User currentUser, String serverDate) {
        this.context = context;
        this.appointmentsList = appointmentsList;
        this.currentUser = currentUser;
    }

    @NonNull
    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_appointment, parent, false);
        return new AppointmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Appointment appointment = appointmentsList.get(position);

        holder.txt_appointment_date.setText(DateUtil.dateToString(appointment.getAppo_date(),
                context.getResources().getString(R.string.word_date_format)));
        holder.txt_appointment_time.setText(String.valueOf(appointment.getAppo_time()));
        holder.txt_appointment_place.setText(appointment.getPlace());
        holder.txt_appointment_dose.setText(String.valueOf( appointment.getDose()));
        holder.txt_appointment_vaccine.setText(appointment.getVaccine());
    }

    @Override
    public int getItemCount() {
		if(appointmentsList == null){
			return 0;
		}
        return appointmentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt_appointment_date;
        private final TextView txt_appointment_time;
        private final TextView txt_appointment_place;
        private final TextView txt_appointment_vaccine;
        private final TextView txt_appointment_dose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_appointment_date = itemView.findViewById(R.id.dateAppointment);
            txt_appointment_time = itemView.findViewById(R.id.timeAppointment);
            txt_appointment_place = itemView.findViewById(R.id.PlaceAppointment);
            txt_appointment_vaccine = itemView.findViewById(R.id.vaccineAppointment);
            txt_appointment_dose = itemView.findViewById(R.id.doseAppointment);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Appointment apppointment = appointmentsList.get(position);


            });
        }
    }

    private void message(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
