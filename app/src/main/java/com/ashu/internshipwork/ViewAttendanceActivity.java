package com.ashu.internshipwork;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Calendar;

public class ViewAttendanceActivity extends AppCompatActivity {

    Spinner spinnerBus;
    EditText etDate;
    Button btnViewAttendance;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        spinnerBus = findViewById(R.id.spinnerBus);
        etDate = findViewById(R.id.etDate);
        btnViewAttendance = findViewById(R.id.btnViewAttendance);
        tvResult = findViewById(R.id.tvResult);

        // Set spinner from GlobalData
        ArrayAdapter<String> busAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                GlobalData.busList.isEmpty() ? Arrays.asList("No Bus Available") : GlobalData.busList);
        spinnerBus.setAdapter(busAdapter);

        // Date picker
        etDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, day) -> {
                etDate.setText(day + "/" + (month + 1) + "/" + year);
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });

        btnViewAttendance.setOnClickListener(v -> {
            String bus = spinnerBus.getSelectedItem().toString();
            String date = etDate.getText().toString().trim();

            if (TextUtils.isEmpty(date) || bus.equals("No Bus Available")) {
                Toast.makeText(this, "Please select date and valid bus", Toast.LENGTH_SHORT).show();
            } else {
                // 🔄 Replace with Firebase later
                tvResult.setText("Showing attendance of " + bus + " on " + date + "\n👉 28 students present.");
            }
        });
    }
}
