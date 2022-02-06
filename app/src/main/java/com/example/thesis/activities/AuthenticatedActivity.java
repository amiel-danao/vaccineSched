package com.example.thesis.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.example.thesis.models.User;
import com.example.thesis.utilities.Generic;

public class AuthenticatedActivity extends AppCompatActivity {
  protected User currentUser;



  @Override
  protected void onCreate(@Nullable Bundle bundle) {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    super.onCreate(bundle);

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

  protected void setRetryPolicy(StringRequest request){
    request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
  }

  protected void gotoActivity(Context packageContext, Class<?> cls){
    Intent intent = new Intent(packageContext, cls);
    intent.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
    startActivity(intent);
  }
}
