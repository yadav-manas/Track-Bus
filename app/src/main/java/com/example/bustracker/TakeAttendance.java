package com.example.bustracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TakeAttendance extends AppCompatActivity {

    ImageButton back;
    TextView route;  //show bus number

    RecyclerView recycler_students;
    Button submitAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_take_attendance);

        back=findViewById(R.id.back);
        route=findViewById(R.id.route);
        submitAttendance=findViewById(R.id.submitAttendance);
        recycler_students=findViewById(R.id.recycler_students);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TakeAttendance.this, DriverDashboard.class));
            }
        });

        //route k data fetch krke aaega kon si bus assigned hai will do it later


// submit wala will do it later
        submitAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TakeAttendance.this,"Submitted",Toast.LENGTH_SHORT).show();
            }
        });

        //for date
        LinearLayout datePickerContainer = findViewById(R.id.datePickerContainer);
        TextView dateText = findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();

// Set current date initially
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        dateText.setText("Date: " + sdf.format(calendar.getTime()));

        datePickerContainer.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    TakeAttendance.this,
                    (view, year1, month1, dayOfMonth) -> {
                        calendar.set(Calendar.YEAR, year1);
                        calendar.set(Calendar.MONTH, month1);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String selectedDate = sdf.format(calendar.getTime());
                        dateText.setText("Date: " + selectedDate);
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });

        recycler_students.setLayoutManager(new LinearLayoutManager(this));
        List<AttendanceModel> attendanceModelList=new ArrayList<>();
        attendanceModelList.add(new AttendanceModel("ABC","23BCA001",false));
        attendanceModelList.add(new AttendanceModel("DEF","23BCA002",false));
        attendanceModelList.add(new AttendanceModel("GHI","23BCA003",false));
        attendanceModelList.add(new AttendanceModel("JKL","23BCA004",false));
        attendanceModelList.add(new AttendanceModel("MNO","23BCA005",false));
        attendanceModelList.add(new AttendanceModel("PQR","23BCA006",false));
        attendanceModelList.add(new AttendanceModel("STU","23BCA007",false));
        attendanceModelList.add(new AttendanceModel("VWX","23BCA008",false));
        attendanceModelList.add(new AttendanceModel("YZA","23BCA009",false));

        AttendanceAdapter adapter =new AttendanceAdapter(attendanceModelList);
        recycler_students.setAdapter(adapter);

    }
}