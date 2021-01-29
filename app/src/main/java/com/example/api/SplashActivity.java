package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Shared shared = new Shared(getApplicationContext());
                if(shared.login()){
                    Intent i =new Intent(SplashActivity.this,Dashboard.class);
                    startActivity(i);
                }else {
                    Intent i =new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                }
                finish();
            }
        },3000);

    }
    @Override
    protected void onStart() {
        super.onStart();

    }
}