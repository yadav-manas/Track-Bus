package com.ashu.internshipwork;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddBusActivity extends AppCompatActivity {

    EditText etBusNo, etRoute, etCapacity;
    Button btnAddBus;
    RecyclerView recyclerView;
    BusAdapter busAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bus);

        etBusNo = findViewById(R.id.etBusNo);
        etRoute = findViewById(R.id.etRoute);
        etCapacity = findViewById(R.id.etCapacity);
        btnAddBus = findViewById(R.id.btnAddBus);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        busAdapter = new BusAdapter(GlobalData.busModels);
        recyclerView.setAdapter(busAdapter);

        btnAddBus.setOnClickListener(v -> {
            String busNo = etBusNo.getText().toString().trim();
            String route = etRoute.getText().toString().trim();
            String capText = etCapacity.getText().toString().trim();

            if (TextUtils.isEmpty(busNo) || TextUtils.isEmpty(route) || TextUtils.isEmpty(capText)) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int capacity;
            try {
                capacity = Integer.parseInt(capText);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid capacity", Toast.LENGTH_SHORT).show();
                return;
            }

            BusModel model = new BusModel(busNo, route, capacity);
            GlobalData.busModels.add(model);
            GlobalData.busList.add(busNo);
            busAdapter.notifyItemInserted(GlobalData.busModels.size() - 1);

            Toast.makeText(this, "Bus Added Successfully", Toast.LENGTH_SHORT).show();

            etBusNo.setText("");
            etRoute.setText("");
            etCapacity.setText("");
        });
    }
}
