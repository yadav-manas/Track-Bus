package com.example.bustracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DriverDashboard extends AppCompatActivity {
    TextView driver_name;
    TextView bus_num;
    ImageButton profileIcon;

    TextView tracking_off;
    TextView tracking_on;
    CardView start_tracking;
    CardView stop_tracking;
    CardView take_attendance;
    CardView edit_attendance;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_dashboard);

        driver_name=findViewById(R.id.driver_name);
        bus_num=findViewById(R.id.bus_num);
        profileIcon=findViewById(R.id.profileIcon);
        tracking_off=findViewById(R.id.tracking_off);
        tracking_on=findViewById(R.id.tracking_on);
        start_tracking=findViewById(R.id.start_tracking);
        stop_tracking=findViewById(R.id.stop_tracking);
        take_attendance=findViewById(R.id.take_attendance);
        edit_attendance=findViewById(R.id.edit_attendance);
        bottomNavigation=findViewById(R.id.bottomNavigation);


        //bottom navigation
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // already here
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(DriverDashboard.this, DriverProfile.class));
                    return true;
                } else if (id == R.id.nav_notifications) {
                    startActivity(new Intent(DriverDashboard.this, DriverNotifications.class));
                    return true;
                }
                return false;
            }
        });


        //icon redirects to profile page
         profileIcon.setOnClickListener(v -> {
             Intent intent= new Intent(DriverDashboard.this , DriverProfile.class);
             startActivity(intent);
         });

         take_attendance.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent =new Intent(DriverDashboard.this, TakeAttendance.class);
                 startActivity(intent);
             }
         });

         edit_attendance.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(DriverDashboard.this, EditAttendance.class));
             }
         });
    }
}