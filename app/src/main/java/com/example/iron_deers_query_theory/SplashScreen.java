package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new HomeFragment()).commit();
            }
        }, 2000);
    }
}