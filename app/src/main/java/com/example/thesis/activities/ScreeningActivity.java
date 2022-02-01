package com.example.thesis.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import com.example.thesis.adapters.ChecklistItemAdapter;
import com.example.thesis.models.Question;
import com.example.thesis.utilities.Generic;
import com.example.thesis.utilities.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScreeningActivity extends AuthenticatedActivity {

    RecyclerView checklistRecyclerView;

    Toolbar toolbar;
    private final String category = "screening";
    private final String answer_column = "answer_screening";


    private ChecklistItemAdapter checklistItemAdapter;
    private ProgressDialog progressDialog;

    private Button confirmButton;
    private Question acceptQuestion;

    private void getViews(){
        toolbar = findViewById(R.id.toolbar);
        checklistRecyclerView = findViewById(R.id.recycler_view_checklist);
        confirmButton = findViewById(R.id.btn_confirm_screening);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        if(isFinishing()){
            return;
        }

        getViews();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.questions_loading_message));
        progressDialog.setCancelable(false);

        setSupportActionBar(toolbar);
        getQuestions();

    }

    private void getQuestions(){
        progressDialog.show();
        String url = Urls.GET_QUESTIONS_URL + "?category=" + category;

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {

                Type typeModelQuestions = new TypeToken<ArrayList<Question>>() {
                }.getType();

                checklistItemAdapter = new ChecklistItemAdapter();
                checklistRecyclerView.setAdapter(checklistItemAdapter);
                checklistRecyclerView.setLayoutManager(new LinearLayoutManager(ScreeningActivity.this));

                checklistItemAdapter.setChecklistItems(new Gson().fromJson(response, typeModelQuestions));

                acceptQuestion = new Question();
                acceptQuestion.setQuestion(getResources().getString(R.string.accept_screening));
                checklistItemAdapter.addChecklistItem(acceptQuestion);

                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(acceptQuestion.isChecked()){
                            if(!isAllowedToProceed()) {
                                message("You are not allowed to be vaccinated!");
                            }
                            else{
                                saveAnswers();
                            }
                        }
                        else{
                            message("Please check the confirmation");
                        }
                    }
                });

            } catch (Exception e) {
                message(e.getMessage());
                e.printStackTrace();
            }

            progressDialog.dismiss();
        }, error -> {

            if (error instanceof TimeoutError) {
                message(getString(R.string.error_network_timeout));
            } else if (error instanceof NoConnectionError) {
                message(getString(R.string.error_network_no_connection));
            } else if (error instanceof AuthFailureError) {
                message(getString(R.string.error_network_auth));
            } else if (error instanceof ServerError) {
                message(getString(R.string.error_network_server));
            } else if (error instanceof NetworkError) {
                message(getString(R.string.error_network));
            } else if (error instanceof ParseError) {
                message(getString(R.string.error_parse));
            } else {
                message(getString(R.string.error_status));
            }

            progressDialog.dismiss();
        });

        RequestQueue requestQueue = Volley.newRequestQueue(ScreeningActivity.this);
        requestQueue.add(request);
    }

    private boolean isAllowedToProceed() {
        int totalQuestions = checklistItemAdapter.getItemCount();
        int negativeAnswersCount = 0;
        for(int i=0; i< totalQuestions; i++){
            if(checklistItemAdapter.getList().get(i).isChecked()){
                negativeAnswersCount++;
            }
        }

        if(negativeAnswersCount > totalQuestions/2){
            return false;
        }

        return true;
    }

    private void saveAnswers() {
        progressDialog.setMessage(getString(R.string.loading_saving_answers));
        progressDialog.show();
        String url = Urls.UPDATE_ANSWERS_URL;

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            Log.d(Generic.TAG, "Response is : " + response);
            if(response.equals("User updated Successfully"))
            {
                gotoActivity(ScreeningActivity.this, VaccinesActivity.class);
            }
            else {
                message("Saving failed!");
            }
            progressDialog.dismiss();
        }, error -> {

            if (error instanceof TimeoutError) {
                message(getString(R.string.error_network_timeout));
            } else if (error instanceof NoConnectionError) {
                message(getString(R.string.error_network_no_connection));
            } else if (error instanceof AuthFailureError) {
                message(getString(R.string.error_network_auth));
            } else if (error instanceof ServerError) {
                message(getString(R.string.error_network_server));
            } else if (error instanceof NetworkError) {
                message(getString(R.string.error_network));
            } else if (error instanceof ParseError) {
                message(getString(R.string.error_parse));
            } else {
                message(getString(R.string.error_status));
            }

            progressDialog.dismiss();
        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                Map <String,String> params = new HashMap<>();
                params.put("user_id", String.valueOf(currentUser.getUser_id()));
                params.put("answers", checklistItemAdapter.getJsonAnswers());
                params.put("category", answer_column);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(ScreeningActivity.this);
        requestQueue.add(request);
    }

    private void message(String message){
        Toast.makeText(ScreeningActivity.this, message, Toast.LENGTH_LONG).show();
    }
}