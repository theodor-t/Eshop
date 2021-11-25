package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphlash);
        SystemClock.sleep(3000);
        Intent loginIntent = new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}