package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Home View
   CardView cardView1,cardView2,cardView3,cardView4;
   DrawerLayout drawerLayout;
   NavigationView navigationView;
   Toolbar toolbar;
   MenuItem menuItem;
   User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            currentUser = (User)bundle.getSerializable("userLoggedIn");
        }
//for clickable dashboard
        cardView1=(CardView)findViewById(R.id.cardview1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, History.class);
                startActivity(intent);
            }
        });

        cardView2 =(CardView)findViewById(R.id.cardview2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, Notification.class);
                startActivity(intent);
            }
        });


        cardView4 =(CardView)findViewById(R.id.cardview4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, YourAppointment.class);
                startActivity(intent);
            }
        });
        //end of clickable dashboard

























        //for drawer layout
        drawerLayout=findViewById(R.id.drawer_Layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);


        //for toolbar
        setSupportActionBar(toolbar);
        //end for toolbar

        //for navigatation bar
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //end for navigatation bar























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
                Intent intent = new Intent(MainActivity3.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                EditProfile();
                break;
        }

        return true;
    }
    public void EditProfile(){
        Intent intent1 = new Intent(MainActivity3.this, EditProfile.class);
        startActivity(intent1);
    }

    public void ShowVaccines(View view) {
        Intent intent = new Intent(MainActivity3.this,VaccinesList.class);
        startActivity(intent);
    }
}
