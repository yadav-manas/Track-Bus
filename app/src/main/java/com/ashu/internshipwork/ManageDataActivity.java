
package com.ashu.internshipwork;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class ManageDataActivity extends AppCompatActivity {

    Spinner spinnerType;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_data);

        spinnerType = findViewById(R.id.spinnerType);
        recyclerView = findViewById(R.id.recyclerViewManage);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                Arrays.asList("Students", "Drivers", "Buses"));
        spinnerType.setAdapter(adapter);

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadData(position);
            }

            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void loadData(int type) {
        switch (type) {
            case 0:
                recyclerView.setAdapter(new StudentManageAdapter(GlobalData.studentModels));
                break;
            case 1:
                recyclerView.setAdapter(new DriverManageAdapter(GlobalData.driverModels));
                break;
            case 2:
                recyclerView.setAdapter(new BusManageAdapter(GlobalData.busModels));
                break;
        }
    }
}