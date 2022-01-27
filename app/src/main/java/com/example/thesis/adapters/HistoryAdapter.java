package com.example.thesis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.thesis.R;
import com.example.thesis.models.History;
import com.example.thesis.models.User;
import com.example.thesis.utilities.DateUtil;
import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<History> historyList;
    private final User currentUser;

    public HistoryAdapter(Context context, ArrayList<History> historyList, User currentUser) {
        this.context = context;
        this.historyList = historyList;
        this.currentUser = currentUser;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_history, parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = historyList.get(position);

        holder.txt_appointment_date.setText(DateUtil.dateToString(history.getAppo_date(),
                context.getResources().getString(R.string.word_date_format)));
        holder.txt_appointment_time.setText(String.valueOf(history.getAppo_time()));
        holder.txt_appointment_dose.setText(String.valueOf(history.getDose()));
        holder.txt_appointment_vaccine.setText(history.getVaccine());
    }

    @Override
    public int getItemCount() {
		if(historyList == null){
			return 0;
		}
		
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt_appointment_date;
        private final TextView txt_appointment_time;
        private final TextView txt_appointment_vaccine;
        private final TextView txt_appointment_dose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_appointment_date = itemView.findViewById(R.id.dateHistory);
            txt_appointment_time = itemView.findViewById(R.id.timeHistory);
            txt_appointment_vaccine = itemView.findViewById(R.id.vaccineHistory);
            txt_appointment_dose = itemView.findViewById(R.id.doseHistory);
        }
    }
}