package com.example.iron_deers_query_theory.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.iron_deers_query_theory.MainActivity;
import com.example.iron_deers_query_theory.R;

public class StartScreen extends AppCompatActivity
{
    Button start_Learning;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        start_Learning = findViewById(R.id.start_Going);
        start_Learning.setOnClickListener(v ->
        {
         Intent intent = new Intent(StartScreen.this, MainActivity.class);
         startActivity(intent);
        });

    }
}
