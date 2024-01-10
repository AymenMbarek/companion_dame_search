package com.jayram.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText3);
        Button login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                // Check if email and password are not empty
                if (txt_email.isEmpty() || txt_password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with login if fields are not empty
                    loginUser(txt_email, txt_password);
                    startActivity(new Intent(LoginActivity.this, Choose.class));
                    finish();
                }
            }
        });
    }

    private void loginUser(String email, String password) {
        Toast.makeText(LoginActivity.this, "Logged in Successfully!", Toast.LENGTH_SHORT).show();
        // You can add your login logic here
    }
}
