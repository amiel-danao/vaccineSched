package com.example.thesis.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.thesis.R;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.Generic;

public class VaccinePreviewActivity extends AuthenticatedActivity {
    private Button btnVaccineSelect;
    TextView title,description,dose;
    private Vaccine selectedVaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_preview);

        if(isFinishing()){
            return;
        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        checkSelectedVaccine(bundle);

        getViews();
        setVaccineInfo();

        btnVaccineSelect = (Button) findViewById(R.id.btnVaccineSelect);
        btnVaccineSelect.setOnClickListener(v -> {
                    Intent intent1 = new Intent(VaccinePreviewActivity.this, SchedulesActivity.class);
                    intent1.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
                    intent1.putExtra(Generic.SELECTED_VACCINE_TAG, selectedVaccine);
                    startActivity(intent1);
                }
        );
    }

    private void setVaccineInfo() {
        title.setText(selectedVaccine.getName());
        description.setText(selectedVaccine.getDescription());
        dose.setText(String.valueOf(selectedVaccine.getDose()));
    }

    private void getViews() {
        title = findViewById(R.id.title1);
        description = findViewById(R.id.description1);
        dose = findViewById(R.id.dose);
    }

    private void checkSelectedVaccine(Bundle bundle) {

        if(bundle != null){
            selectedVaccine = (Vaccine)bundle.getSerializable(Generic.SELECTED_VACCINE_TAG);
        }

        if(selectedVaccine == null){
            finish();
            Intent intent = new Intent(VaccinePreviewActivity.this, VaccinesActivity.class);
            startActivity(intent);
        }
    }
}
