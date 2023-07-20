package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
