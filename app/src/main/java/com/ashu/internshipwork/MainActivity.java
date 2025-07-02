package com.ashu.internshipwork;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ashu.internshipwork.R;

public class MainActivity extends AppCompatActivity {

    LinearLayout cardAddBus, cardAddStudent, cardAddDriver,
            cardTrackBus, cardViewAttendance, cardEditDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // or your actual layout name

        cardAddBus = findViewById(R.id.cardAddBus);
        cardAddStudent = findViewById(R.id.cardAddStudent);
        cardAddDriver = findViewById(R.id.cardAddDriver);
        cardTrackBus = findViewById(R.id.cardTrackBus);
        cardViewAttendance = findViewById(R.id.cardViewAttendance);
        cardEditDelete = findViewById(R.id.cardEditDelete);

        cardAddBus.setOnClickListener(v ->
                startActivity(new Intent(this, com.ashu.internshipwork.AddBusActivity.class)));

        cardAddStudent.setOnClickListener(v ->
                startActivity(new Intent(this, AddStudentActivity.class)));

        cardAddDriver.setOnClickListener(v ->
                startActivity(new Intent(this, AddDriverActivity.class)));

        cardTrackBus.setOnClickListener(v ->
                startActivity(new Intent(this, TrackBusActivity.class)));

        cardViewAttendance.setOnClickListener(v ->
                startActivity(new Intent(this, ViewAttendanceActivity.class)));

        cardEditDelete.setOnClickListener(v ->
                startActivity(new Intent(this, ManageDataActivity.class)));
    }
}
