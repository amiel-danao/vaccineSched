package com.example.thesis;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VaccinesList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private VaccinesAdapter vaccinesAdapter;
    private List<Vaccine> vaccineList;
    //vaccine information
     @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_vaccine);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        vaccineList = new ArrayList<>();


        LoadAllVaccines();
    }

    private void LoadAllVaccines() {
        JsonArrayRequest request = new JsonArrayRequest(Urls.SHOW_ALL_VACCINES, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray array) {
                for(int i = 0; i < array.length(); i++){
                    try {
                        JSONObject object = array.getJSONObject(i);
                        String name = object.getString("name").trim();
                        String description = object.getString("description").trim();

                        Vaccine vaccine = new Vaccine();
                        vaccine.setName(name);
                        vaccine.setDescription(description);
                        vaccineList.add(vaccine);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                vaccinesAdapter = new VaccinesAdapter(VaccinesList.this, vaccineList);
                recyclerView.setAdapter(vaccinesAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VaccinesList.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(VaccinesList.this);
        requestQueue.add(request);
    }
}