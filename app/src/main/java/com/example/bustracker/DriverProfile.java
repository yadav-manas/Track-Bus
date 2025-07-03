package com.example.bustracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DriverProfile extends AppCompatActivity {

ImageButton back;
CardView logout;
ImageView cameraIcon;
BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_profile);

        back=findViewById(R.id.back);
        logout=findViewById(R.id.logout);
        cameraIcon=findViewById(R.id.cameraIcon);
        bottomNavigation=findViewById(R.id.bottomNavigation);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverProfile.this,DriverDashboard.class));
            }
        });

        logout.setOnClickListener(v -> {
            // Inflate the custom layout
            View dialogView = getLayoutInflater().inflate(R.layout.activity_logout, null);

            // Initialize buttons from the custom layout
            Button cancelBtn = dialogView.findViewById(R.id.logoutCancel);
            Button confirmBtn = dialogView.findViewById(R.id.logoutConfirm);

            // Create the dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(DriverProfile.this);
            builder.setView(dialogView);
            AlertDialog dialog = builder.create();

            // Cancel button dismisses dialog
            cancelBtn.setOnClickListener(view -> dialog.dismiss());

            // Confirm button logs out
//            confirmBtn.setOnClickListener(view -> {
//                // FirebaseAuth.getInstance().signOut();  // Uncomment if using Firebase Auth
//                Intent intent = new Intent(DriverProfile.this, DriverLogin.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
//            });

            // Show dialog
            dialog.show();
        });

//        profile edit pending
        bottomNavigation.setSelectedItemId(R.id.nav_profile);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    startActivity(new Intent(DriverProfile.this, DriverDashboard.class));
                    return true;
                } else if (id == R.id.nav_profile) {
                    //already here
                    return true;
                } else if (id == R.id.nav_notifications) {
                    startActivity(new Intent(DriverProfile.this, DriverNotifications.class));
                    return true;
                }
                return false;
            }
        });




    }
}