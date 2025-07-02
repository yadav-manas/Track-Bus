package com.ashu.internshipwork;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class TrackBusActivity extends AppCompatActivity {

    Spinner spinnerBus;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_bus);

        spinnerBus = findViewById(R.id.spinnerBus);
        btnCheck = findViewById(R.id.btnCheckTracking);
        tvResult = findViewById(R.id.tvResult);

        loadBusList();

        btnCheck.setOnClickListener(v -> {
            String selectedBus = spinnerBus.getSelectedItem().toString();
            if (selectedBus.equals("No Bus Available")) {
                tvResult.setText("No bus available to track.");
            } else {
                tvResult.setText("Tracking status of " + selectedBus + ": 🚍 Not live currently.");
            }
        });
    }

    private void loadBusList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                GlobalData.busList.isEmpty() ? Arrays.asList("No Bus Available") : GlobalData.busList
        );
        spinnerBus.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBusList(); // reload in case user added new bus
    }
}
