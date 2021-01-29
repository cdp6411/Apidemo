package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextTextEmailAddress,editTextTextPassword;
    Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextEmailAddress=findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword=findViewById(R.id.editTextTextPassword);
        login_button=findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextTextEmailAddress.getText().toString().equals("admin@iroidsolutions.com") &&
                editTextTextPassword.getText().toString().equals("admin"))
                {
                    Intent buttonintent = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(buttonintent);
                    finish();

                    Shared shared = new Shared(getApplicationContext());
                    shared.secondtime();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Your Email & password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}