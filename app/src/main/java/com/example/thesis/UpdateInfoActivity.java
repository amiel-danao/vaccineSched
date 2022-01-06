package com.example.thesis;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ahmadabuhasan.volleygsonxampp.ApiClient;
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
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class UpdateInfoActivity extends AppCompatActivity {

    private EditText editText_nim, editText_name, editText_class;
    private String edit_name, edit_class;
    private int edit_id, edit_nim;
    private Button btn_save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_for_appointment);
        
        /*editText_nim = findViewById(R.id.et_nim);
        editText_name = findViewById(R.id.et_name);
        editText_class = findViewById(R.id.et_class);
        btn_save = findViewById(R.id.save_add_edit);

        btn_save.setText(R.string.update);*/

        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            edit_id = intent.getInt("edit_id");
            edit_nim = intent.getInt("edit_nim");
            edit_name = intent.getString("edit_name");
            edit_class = intent.getString("edit_class");
        }

        editText_nim.setText(String.valueOf(edit_nim));
        editText_name.setText(edit_name);
        editText_class.setText(edit_class);

        btn_save.setOnClickListener(v -> {
            String nim = editText_nim.getText().toString();
            String name = editText_name.getText().toString();
            String classs = editText_class.getText().toString();

            if (nim.isEmpty()) {
                Toast.makeText(UpdateInfoActivity.this, "NIM Still Empty!", Toast.LENGTH_SHORT).show();
            } else if (name.isEmpty()) {
                Toast.makeText(UpdateInfoActivity.this, "Name Still Empty!", Toast.LENGTH_SHORT).show();
            } else if (classs.isEmpty()) {
                Toast.makeText(UpdateInfoActivity.this, "Class Still Empty!", Toast.LENGTH_SHORT).show();
            } else {
                updateData(edit_id, nim, name, classs);
            }
        });


    }

    private void updateData(int id, String nim, String name, String classs) {
        String url = ApiClient.URL_UPDATE_INFO;
        
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            ResponseStatus responseStatus = new Gson().fromJson(response, ResponseStatus.class);
            int status_kode = responseStatus.getStatus_code();
            String status_pesan = responseStatus.getStatus_message();

            if (status_kode == 1) {
                Toast.makeText(UpdateInfoActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
                //MainActivity.mInstance.MuatData();
                finish();
            }
            else{
                Toast.makeText(UpdateInfoActivity.this, status_pesan, Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            
            if (error instanceof TimeoutError) {
                Toast.makeText(UpdateInfoActivity.this, "Network TimeoutError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NoConnectionError) {
                Toast.makeText(UpdateInfoActivity.this, "Nerwork NoConnectionError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof AuthFailureError) {
                Toast.makeText(UpdateInfoActivity.this, "Network AuthFailureError", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ServerError) {
                Toast.makeText(UpdateInfoActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof NetworkError) {
                Toast.makeText(UpdateInfoActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            } else if (error instanceof ParseError) {
                Toast.makeText(UpdateInfoActivity.this, "Parse Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(UpdateInfoActivity.this, "Status Error!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                // set ke params
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("id", String.valueOf(id));
                hashMap.put("nim", nim);
                hashMap.put("name", name);
                hashMap.put("class", classs);

                return hashMap;
            }
        };
        
        //AppController.getInstance().addToQueue(request, "edit_data");
        RequestQueue requestQueue = Volley.newRequestQueue(UpdateInfoActivity.this);
        requestQueue.add(request);
    }
}
