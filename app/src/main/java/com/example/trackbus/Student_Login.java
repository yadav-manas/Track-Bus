package com.example.trackbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Student_Login extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginButton;

    // Hardcoded credentials (for now)
    final String validEmail = "student@bus.com";
    final String validPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login); // your XML layout file

        // ID initialization
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        // Login Button click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (email.equals(validEmail) && password.equals(validPassword)) {
                    // Login success
                    Toast.makeText(Student_Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Student_Login.this, Student_Dashboard.class); // ✅ fixed class name
                    startActivity(intent);
                    finish();
                } else {
                    // Login failed
                    Toast.makeText(Student_Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
