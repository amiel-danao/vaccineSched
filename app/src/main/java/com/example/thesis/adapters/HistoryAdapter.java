package com.example.thesis.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thesis.R;
import com.example.thesis.activities.EditProfileActivity;
import com.example.thesis.activities.HomeActivity;
import com.example.thesis.activities.ScreeningActivity;
import com.example.thesis.models.History;
import com.example.thesis.models.Question;
import com.example.thesis.models.User;
import com.example.thesis.utilities.DateUtil;
import com.example.thesis.utilities.Generic;
import com.example.thesis.utilities.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<History> historyList;
    private final User currentUser;
    private ProgressDialog progressDialog;

    public HistoryAdapter(Context context, ArrayList<History> historyList, User currentUser) {
        this.context = context;
        this.historyList = historyList;
        this.currentUser = currentUser;

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending feedback...");
        progressDialog.setCancelable(false);
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
        holder.txt_appointment_status.setText(String.valueOf(history.getStatus()));
        holder.txt_appointment_vaccine.setText(history.getVaccine());

        if(history.getStatus().toLowerCase().equals("vaccinated") ||
			history.getStatus().toLowerCase().equals("1st dose done") ||
			history.getStatus().toLowerCase().equals("2nd dose done")){
				
            holder.btn_feedback.setTag(history);
            holder.btn_feedback.setVisibility(View.VISIBLE);
            holder.btn_feedback.setOnClickListener(feedback_click_listener);
        }
        else{
            holder.btn_feedback.setVisibility(View.GONE);
        }
    }

    private View.OnClickListener feedback_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            History history = (History)view.getTag();
            final int appo_id = history.getAppo_id();

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("What's your feedback");

// Set up the input
            final EditText input = new EditText(context);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String feedbackToSave = input.getText().toString();
                    if(!feedbackToSave.isEmpty()) {
                        saveFeedBack(feedbackToSave, appo_id, view);
                    }
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    };

    private void saveFeedBack(String feedbackToSave, int appo_id, View view) {
        progressDialog.show();
        String url = Urls.UPDATE_FEEDBACK_URL;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {

            if(response.equals("OK")){
                message("Feedback sent successfully.");
                view.setVisibility(View.GONE);
            }

            Log.d(Generic.TAG, response);

            progressDialog.hide();

        }, error -> {

            if (error instanceof TimeoutError) {
                message(context.getString(R.string.error_network_timeout));
            } else if (error instanceof NoConnectionError) {
                message(context.getString(R.string.error_network_no_connection));
            } else if (error instanceof AuthFailureError) {
                message(context.getString(R.string.error_network_auth));
            } else if (error instanceof ServerError) {
                message(context.getString(R.string.error_network_server));
            } else if (error instanceof NetworkError) {
                message(context.getString(R.string.error_network));
            } else if (error instanceof ParseError) {
                message(context.getString(R.string.error_parse));
            } else {
                message(context.getString(R.string.error_status));
            }

            progressDialog.dismiss();
        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                Map <String,String> params = new HashMap<>();
                params.put("appo_id", String.valueOf(appo_id));
                params.put("feedback", feedbackToSave);
                params.put("user_id", String.valueOf(currentUser.getUser_id()));

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
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
        private final TextView txt_appointment_status;
        private final Button btn_feedback;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_appointment_date = itemView.findViewById(R.id.dateHistory);
            txt_appointment_time = itemView.findViewById(R.id.timeHistory);
            txt_appointment_vaccine = itemView.findViewById(R.id.vaccineHistory);
            txt_appointment_status = itemView.findViewById(R.id.statusHistory);
            btn_feedback = itemView.findViewById(R.id.btn_feedback);
        }
    }

    private void message(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}