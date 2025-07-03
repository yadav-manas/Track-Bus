package com.example.bustracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class EditAttendance extends AppCompatActivity {

    ImageButton back;
    TextView route;  //show bus number

    RecyclerView recycler_students;
    Button savechanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_attendance);
        back=findViewById(R.id.back);
        route=findViewById(R.id.route);
        savechanges=findViewById(R.id.savechanges);
        recycler_students=findViewById(R.id.recycler_students);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditAttendance.this, DriverDashboard.class));
            }
        });

        recycler_students.setVisibility(View.GONE);

        LinearLayout datePickerContainer = findViewById(R.id.datePickerContainer);
        TextView dateText = findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        datePickerContainer.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            dateText.setText("Date: " + sdf.format(calendar.getTime()));
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    EditAttendance.this,
                    (view, year1, month1, dayOfMonth) -> {
// After date is selected
                        calendar.set(Calendar.YEAR, year1);
                        calendar.set(Calendar.MONTH, month1);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String selectedDate = sdf.format(calendar.getTime());
                        dateText.setText("Date: " + selectedDate);

                        recycler_students.setVisibility(View.VISIBLE);

                        List<AttendanceModel> attendanceList = new ArrayList<>();
                        attendanceList.add(new AttendanceModel("ABC","23BCA001",false));
                        attendanceList.add(new AttendanceModel("DEF","23BCA002",true));
                        attendanceList.add(new AttendanceModel("GHI","23BCA003",true));
                        attendanceList.add(new AttendanceModel("JKL","23BCA004",true));
                        attendanceList.add(new AttendanceModel("MNO","23BCA005",false));
                        attendanceList.add(new AttendanceModel("PQR","23BCA006",false));
                        attendanceList.add(new AttendanceModel("STU","23BCA007",true));
                        attendanceList.add(new AttendanceModel("VWX","23BCA008",true));
                        attendanceList.add(new AttendanceModel("YZA","23BCA009",false));

                        recycler_students.setLayoutManager(new LinearLayoutManager(EditAttendance.this));
                        AttendanceAdapter adapter = new AttendanceAdapter(attendanceList);
                        recycler_students.setAdapter(adapter);

                        savechanges.setVisibility(View.VISIBLE);

                    },
                    year, month, day
            );
            datePickerDialog.show();
        });

        savechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditAttendance.this,"Saved",Toast.LENGTH_SHORT).show();
            }
        });
    }
}