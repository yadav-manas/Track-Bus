package com.example.bustracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DriverNotifications extends AppCompatActivity {

    ImageButton back;
    RecyclerView notificationsRecyclerView;
BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drivernotifications);
        back=findViewById(R.id.back);
        notificationsRecyclerView=findViewById(R.id.notificationsRecyclerView);
        bottomNavigation=findViewById(R.id.bottomNavigation);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverNotifications.this,DriverDashboard.class));
            }
        });
        bottomNavigation.setSelectedItemId(R.id.nav_notifications);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    startActivity(new Intent(DriverNotifications.this, DriverDashboard.class));
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(DriverNotifications.this, DriverProfile.class));
                    return true;
                } else if (id == R.id.nav_notifications) {
                    //already here
                    return true;
                }
                return false;
            }
        });


    }
}