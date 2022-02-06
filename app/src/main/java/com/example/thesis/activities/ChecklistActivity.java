package com.example.thesis.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;

public class ChecklistActivity extends AuthenticatedActivity {

    RecyclerView checklistRecyclerView;

    Toolbar toolbar;
    private final String category = "checklist";
    private final String answer_column = "answer_checklist";


    private ChecklistItemAdapter checklistItemAdapter;
	private ProgressDialog progressDialog;

	private Button confirmButton;
	private Question acceptQuestion;
    private SharedPreferences sharedPref;

    private void getViews(){
        toolbar = findViewById(R.id.toolbar);
        checklistRecyclerView = findViewById(R.id.recycler_view_checklist);
        confirmButton = findViewById(R.id.btn_confirm_checklist);
    }
	
	private void showInstruction(){
		AlertDialog alertDialog = new AlertDialog.Builder(ChecklistActivity.this).create();
		alertDialog.setTitle("Instruction");
		alertDialog.setMessage("Check the box if yes leave it blank if no.");
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
		alertDialog.show();
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
		
		if(isFinishing()){
            return;
        }

        sharedPref = getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();

		showInstruction();

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
				checklistRecyclerView.setLayoutManager(new LinearLayoutManager(ChecklistActivity.this));
				
				checklistItemAdapter.setChecklistItems(new Gson().fromJson(response, typeModelQuestions));

                acceptQuestion = new Question();
                acceptQuestion.setQuestion(getResources().getString(R.string.accept_checklist));
				checklistItemAdapter.addChecklistItem(acceptQuestion);

                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(acceptQuestion.isChecked()){
                            if(!isAllowedToProceed()) {
                                message("You are not allowed to be vaccinated!");
                            }
                            else{
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString(Generic.ANSWERS_CHECKLIST_KEY, checklistItemAdapter.getJsonAnswers());
                                editor.apply();
                                gotoActivity(ChecklistActivity.this, ScreeningActivity.class);
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

        setRetryPolicy(request);
        RequestQueue requestQueue = Volley.newRequestQueue(ChecklistActivity.this);
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



    private void message(String message){
        Toast.makeText(ChecklistActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
