package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class HistoryQuestion extends AppCompatActivity {

    ImageView CatIcon;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_question);

        CatIcon = findViewById(R.id.Cat);
        CatIcon.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryQuestion.this, Categories.class);
            startActivity(intent);
        });
    }
}