package com.ashu.internshipwork;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class AddDriverActivity extends AppCompatActivity {

    Spinner spinnerBus;
    EditText etDriverName, etDriverId, etPassword;
    Button btnAddDriver;
    RecyclerView recyclerDriver;

    DriverAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);

        spinnerBus = findViewById(R.id.spinnerBus);
        etDriverName = findViewById(R.id.etDriverName);
        etDriverId = findViewById(R.id.etDriverId);
        etPassword = findViewById(R.id.etPassword);
        btnAddDriver = findViewById(R.id.btnAddDriver);
        recyclerDriver = findViewById(R.id.recyclerDriver);

        ArrayAdapter<String> busAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                GlobalData.busList.isEmpty() ? Arrays.asList("No Bus Available") : GlobalData.busList);
        spinnerBus.setAdapter(busAdapter);

        adapter = new DriverAdapter(GlobalData.driverModels);
        recyclerDriver.setLayoutManager(new LinearLayoutManager(this));
        recyclerDriver.setAdapter(adapter);

        btnAddDriver.setOnClickListener(v -> {
            String name = etDriverName.getText().toString().trim();
            String bus = spinnerBus.getSelectedItem().toString();
            String id = etDriverId.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(id) || TextUtils.isEmpty(pass) || bus.equals("No Bus Available")) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                DriverModel driver = new DriverModel(name, bus, id, pass);
                GlobalData.driverModels.add(driver); // ✅ only add to global

                adapter.notifyItemInserted(GlobalData.driverModels.size() - 1);
                Toast.makeText(this, "Driver Added", Toast.LENGTH_SHORT).show();

                etDriverName.setText("");
                etDriverId.setText("");
                etPassword.setText("");
            }
        });
    }
}
