package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VaccinePreviewActivity extends AppCompatActivity {
    private Button btnVacnSelect;
    TextView title,description,dose;
    private User currentUser;
    private Vaccine selectedVaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_preview);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        checkCurrentUser(bundle);
        checkSelectedVaccine(bundle);

        getViews();
        setVaccineInfo();

        btnVacnSelect= (Button) findViewById(R.id.btnVacnSelect);
        btnVacnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VaccinePreviewActivity.this, GetAppointment.class);
                startActivity(intent);
            }
        });
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

    private void checkCurrentUser(Bundle bundle) {

        if(bundle != null){
            currentUser = (User)bundle.getSerializable(Generic.USER_LOGGED_IN_TAG);
        }

        if(currentUser == null){
            finish();
            Intent intent = new Intent(VaccinePreviewActivity.this, LoginActivity.class);
            startActivity(intent);
        }
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
