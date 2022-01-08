package com.example.thesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
   private User currentUser;
   private TextView txtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            currentUser = (User)bundle.getSerializable(Generic.USER_LOGGED_IN_TAG);
        }

        if(currentUser == null){
            finish();
            intent = new Intent(MainActivity3.this, LoginActivity.class);
            startActivity(intent);
            return;
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

        cardView3 =(CardView)findViewById(R.id.cardview3);
        cardView3.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity3.this, VaccinesActivity.class);
            intent1.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
            startActivity(intent1);
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

        txtUserName = navigationView.getHeaderView(0).findViewById(R.id.UserName);
        txtUserName.setText(currentUser.getFirstname() + " " + currentUser.getLastname());
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
        Intent intent1 = new Intent(MainActivity3.this, EditProfileActivity.class);
        intent1.putExtra(Generic.USER_LOGGED_IN_TAG, currentUser);
        startActivity(intent1);
    }
}
