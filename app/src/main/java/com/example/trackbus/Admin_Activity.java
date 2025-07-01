package com.example.trackbus;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Activity extends AppCompatActivity {

    ImageView logoImage;
    TextView adminTitle, forgotPassword, footerNote;
    EditText emailInput, passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);  // Make sure your XML file name is activity_admin.xml

        // Initialize views
        logoImage = findViewById(R.id.logoImage);
        adminTitle = findViewById(R.id.adminTitle);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        footerNote = findViewById(R.id.footerNote);

        // Login button click event
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Admin_Activity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Dummy login check
                    if (email.equals("admin@smartbus.com") && password.equals("admin123")) {
                        Toast.makeText(Admin_Activity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        // TODO: Navigate to Admin Dashboard
                    } else {
                        Toast.makeText(Admin_Activity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Forgot password click
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin_Activity.this, "Password recovery not implemented", Toast.LENGTH_SHORT).show();
                // TODO: Launch forgot password activity or dialog
            }
        });
    }
}
