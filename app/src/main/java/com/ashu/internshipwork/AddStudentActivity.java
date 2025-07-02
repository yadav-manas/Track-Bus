package com.ashu.internshipwork;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class AddStudentActivity extends AppCompatActivity {

    Spinner spinnerBus;
    EditText etStudentName, etRollNo, etPassword;
    Button btnAddStudent;
    RecyclerView recyclerStudent;

    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        spinnerBus = findViewById(R.id.spinnerBus);
        etStudentName = findViewById(R.id.etStudentName);
        etRollNo = findViewById(R.id.etRollNo);
        etPassword = findViewById(R.id.etPassword);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        recyclerStudent = findViewById(R.id.recyclerStudent);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                GlobalData.busList.isEmpty() ? Arrays.asList("No Bus Available") : GlobalData.busList);
        spinnerBus.setAdapter(spinnerAdapter);

        adapter = new StudentAdapter(GlobalData.studentModels);
        recyclerStudent.setLayoutManager(new LinearLayoutManager(this));
        recyclerStudent.setAdapter(adapter);

        btnAddStudent.setOnClickListener(v -> {
            String name = etStudentName.getText().toString().trim();
            String roll = etRollNo.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();
            String bus = spinnerBus.getSelectedItem().toString();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(roll) || TextUtils.isEmpty(pass) || bus.equals("No Bus Available")) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Check bus capacity
                int capacity = 0;
                for (BusModel bm : GlobalData.busModels) {
                    if (bm.getBusNo().equals(bus)) {
                        capacity = bm.getCapacity();
                        break;
                    }
                }
                int currentCount = 0;
                for (StudentModel sm : GlobalData.studentModels) {
                    if (sm.getBusNumber().equals(bus)) {
                        currentCount++;
                    }
                }
                if (currentCount >= capacity) {
                    Toast.makeText(this, "Bus is full", Toast.LENGTH_SHORT).show();
                    return;
                }
                StudentModel student = new StudentModel(name, roll, pass, bus);
                GlobalData.studentModels.add(student); // ✅ only add to global

                adapter.notifyItemInserted(GlobalData.studentModels.size() - 1);
                Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();

                etStudentName.setText("");
                etRollNo.setText("");
                etPassword.setText("");
            }
        });
    }
}
