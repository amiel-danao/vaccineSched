package com.example.thesis.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.thesis.utilities.Generic;
import com.example.thesis.History;
import com.example.thesis.Notification;
import com.example.thesis.R;
import com.example.thesis.models.User;
import com.example.thesis.YourAppointment;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AuthenticatedActivity implements NavigationView.OnNavigationItemSelectedListener {

    CardView cardView1,cardView2,cardView3,cardView4;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(isFinishing()){
            return;
        }

//for clickable dashboard
        cardView1=(CardView)findViewById(R.id.cardview1);
        cardView1.setOnClickListener(v -> gotoActivity(HomeActivity.this, History.class));

        cardView2 =(CardView)findViewById(R.id.cardview2);
        cardView2.setOnClickListener(v -> gotoActivity(HomeActivity.this, Notification.class));

        cardView3 =(CardView)findViewById(R.id.cardview3);
        cardView3.setOnClickListener(v -> gotoActivity(HomeActivity.this, VaccinesActivity.class));


        cardView4 =(CardView)findViewById(R.id.cardview4);
        cardView4.setOnClickListener(v -> gotoActivity(HomeActivity.this, YourAppointment.class));
        //end of clickable dashboard

        //for drawer layout
        drawerLayout=findViewById(R.id.drawer_Layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        TextView txtUserName = navigationView.getHeaderView(0).findViewById(R.id.UserName);
        txtUserName.setText(getResources().getString(R.string.full_name, currentUser.getFirstname(), currentUser.getLastname()));
        //for toolbar
        setSupportActionBar(toolbar);
        //end for toolbar

        //for navigatation bar
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            //super.onBackPressed();
        }

    }


    @Override
    //selecting item in navigation bar
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_logout:
                finish();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                gotoActivity(HomeActivity.this, EditProfileActivity.class);
                break;
        }

        return true;
    }
}
