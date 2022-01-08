package com.example.thesis.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thesis.SchedulesActivity;
import com.example.thesis.models.User;
import com.example.thesis.models.Vaccine;
import com.example.thesis.utilities.Generic;

public class AuthenticatedActivity extends AppCompatActivity {
    protected User currentUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkIfLoggedIn(getApplicationContext());
    }

    private void checkIfLoggedIn(Context context) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            currentUser = (User)bundle.getSerializable(Generic.USER_LOGGED_IN_TAG);
        }

        if(currentUser == null){
            finish();
            intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
        }
    }

    protected void gotoActivity(Context packageContext, Class<?> cls){
        Intent intent = new Intent(packageContext, cls);
        intent.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
        startActivity(intent);
    }
}
