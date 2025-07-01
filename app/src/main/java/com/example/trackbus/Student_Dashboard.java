package com.example.trackbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Student_Dashboard extends AppCompatActivity {

    TextView studentGreeting, busAssignedText, crnText;
    CardView viewBusCard, attendanceCard; // ✅ FIXED: Changed to CardView
    LinearLayout homeLayout, notificationLayout, profileLayout;
    ImageView homeIcon, notificationIcon, profileIcon;
    TextView notificationText, profileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Student Info Section
        studentGreeting = findViewById(R.id.studentGreeting);
        busAssignedText = findViewById(R.id.busAssignedText);
        crnText = findViewById(R.id.crnText);

        // Dummy Data
        studentGreeting.setText("Hello, Rahul Sharma");
        busAssignedText.setText("Bus Assigned: Bus No. 12");
        crnText.setText("CRN: 202334");

        // ✅ Correct type: CardView
        viewBusCard = findViewById(R.id.viewBusCard);
        attendanceCard = findViewById(R.id.attendanceCard);

        // Bottom Nav Layouts
        homeLayout = findViewById(R.id.homeLayout);
        notificationLayout = findViewById(R.id.notificationLayout);
        profileLayout = findViewById(R.id.profileLayout);

        // Icons & Texts
        homeIcon = findViewById(R.id.homeIcon);
        notificationIcon = findViewById(R.id.notificationIcon);
        profileIcon = findViewById(R.id.profileIcon);
        notificationText = findViewById(R.id.notificationText);
        profileText = findViewById(R.id.profileText);

        // Card Click Listeners
        viewBusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Student_Dashboard.this, BusLocationActivity.class));
            }
        });

        attendanceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Student_Dashboard.this, AttendanceActivity.class));
            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Student_Dashboard.this, ProfileActivity.class));
            }
        });

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Student_Dashboard.this, NotificationActivity.class));
            }
        });

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on Home
                // You can optionally show a toast: Toast.makeText(this, "You're already here!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
